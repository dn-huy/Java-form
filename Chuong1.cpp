#include<GL/freeglut.h>
#include <math.h>
#include<iostream>
using namespace std;

int width = 800, height = 600;

void Init(void)
{
	// Thiet lap mau nen
	glClearColor(1, 1, 1, 0);
	// Thiet lap phep chieu
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	// Thiet lap he toa do
	gluOrtho2D(-width / 2, width / 2, -height / 2, height / 2);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	return;
}
// Thuật toán Bresenham vẽ đường thẳng 
void BrePoint(int x1, int y1, int x2, int y2)
{

	glColor3f(1, 0, 0);
	glBegin(GL_POINTS);
	int dx = abs(x2 - x1);
	int dy = abs(y2 - y1);
	int p = 2 * dy - dx;
	int c1 = 2 * dy;
	int c2 = 2 * (dy - dx);
	int x = x1; int y = y1;
	glVertex2i(x, y);
	while (x < x2)
	{
		if (p < 0)
		{
			p = p + c1;
		}
		else
		{
			p = p + c2;
			y++;
		}
		x++;
		glVertex2i(x, y);
	}
	glEnd();
	return;

}

//thuật toán Bresenham vẽ hình elip
void BreElip(int xc, int yc, int a, int b)// ve elipse
{
	glColor3f(1, 0, 0);
	glBegin(GL_POINTS);
	float p, a2, b2;
	int x, y;
	a2 = pow(a, 2);
	b2 = pow(b, 2);
	x = 0;
	y = b;

	p = 2 * ((float)b2 / a2) - (2 * b) + 1;

	//ve nhanh thu 1(tu tren xuong )
	while (((float)b2 / a2) * x <= y)
	{
		glVertex2i(xc + x, yc + y);
		glVertex2i(xc - x, yc + y);
		glVertex2i(xc - x, yc - y);
		glVertex2i(xc + x, yc - y);
		if (p < 0)
		{
			p = p + 2 * ((float)b2 / a2) * (2 * x + 3);
		}
		else {
			p = p - 4 * y + 2 * ((float)b2 / a2) * (2 * x + 3);
			y--;
		}
		x++;
	}
	//ve nhanh thu 2(tu duoi len )
	y = 0;
	x = a;
	p = 2 * ((float)a2 / b2) - 2 * a + 1;
	while (((float)a2 / b2) * y <= x)
	{
		glVertex2i(xc + x, yc + y);
		glVertex2i(xc - x, yc + y);
		glVertex2i(xc - x, yc - y);
		glVertex2i(xc + x, yc - y);
		if (p < 0)
		{
			p = p + 2 * ((float)a2 / b2) * (2 * y + 3);
		}
		else
		{
			p = p - 4 * x + 2 * ((float)a2 / b2) * (2 * y + 3);
			x = x - 1;
		}
		y = y + 1;
	}
	glEnd();
	return;
}

//Thuật toán Bresenham vẽ hình tròn
void BresCircle(int xc ,int yc, int r)
{
	glColor3b(1, 1, 0.5);
	glBegin(GL_POINTS);
	int p1;
	p1 = 3 - 2 * r;
	int x = 0;
	int y = r;
	glVertex2i(x, y);
	while (x <= y)
	{
		if (p1 < 0)
		{
			p1 += 4 * x + 6;
		}
		else
		{
			p1 += 4 * (x - y) + 10;
			y--;
		}
		x++;
		glVertex2i(x + xc, y + yc);
		glVertex2i(-x + xc, y + yc);
		glVertex2i(x + xc, -y + yc);
		glVertex2i(-x + xc, -y + yc);
		glVertex2i(y + xc, x + yc);
		glVertex2i(-y + xc, x + yc);
		glVertex2i(y + xc, -x + yc);
		glVertex2i(-y + xc, -x + yc);
	}
	glEnd();
	return;
}

//Thuật toán midpoint vẽ đường thẳng 
void Midpoint(int x1, int y1, int x2, int y2) {
	//Truong hop 0<m<1 && x1<x2 && y1<y2
	glColor3f(1, 0, 0);
	glBegin(GL_POINTS);
	int a, b, pi, x, y, p;
	a = y2 - y1;
	b = -(x2 - x1);
	y = y1;
	x = x1;
	glVertex2i(x, y); //Ve diem pixel dau tien
	p = 2 * a + b;        //tinh vi tri tuong doi cua diem Midpoint so voi duong thang
	while (x < x2) {
		if (p < 0) {
			p += 2 * a; // ta chon chon diem yi
		}
		else {
			y++;
			p += 2 * (a + b);//ta chon diem yi +1
		}
		x++;

		glVertex2i(x, y);
	}
	glEnd();
	return;
}

//Thuật toán Midpoint vẽ hình elip
void DrawElip(int xc, int yc, int a, int b)
{
	glColor3b(1, 0, 0);
	glBegin(GL_POINTS);
	int x, y, fx, fy, a2, b2, p;
	x = 0; y = b;
	a2 = a * a;
	b2 = b * b;
	fx = 0;
	fy = 2 * a2 * y;
	glVertex2i(x, y);
	p = round((b2 - (a2 * b)) + (0.25 * a2));//p=b2 - a2*b +a2/4
	while (fx < fy)
	{
		x++;
		fx += 2 * b2;
		if (p < 0)
		{
			p += b2 * (2 * x + 3);//p=p + b2*(2x +3)
		}
		else
		{
			y--;
			p += b2 * (2 * x + 3) + a2 * (2 - 2 * y);//p=p +b2(2x +3) +a2(2-2y)
			fy -= 2 * a2;
		}
		glVertex2i(xc + x, yc + y);
		glVertex2i(xc - x, yc + y);
		glVertex2i(xc + x, yc - y);
		glVertex2i(xc - x, yc - y);
	}
	p = round(b2 * (x + 0.5) * (x + 0.5) + (a2 * (y - 1) * (y - 1) - a2 * b2));
	while (y > 0)
	{
		y--;
		fy -= 2 * a2;

		if (p >= 0)
		{
			p += a2 * (3 - 2 * y); //p=p +a2(3-2y)
		}
		else
		{
			x++;
			fx += 2 * b2;
			p += b2 * (2 * x + 2) + a2 * (3 - 2 * y);//p=p+ b2(2x +2) + a2(3-2y)
		}
		glVertex2i(xc + x, yc + y);
		glVertex2i(xc - x, yc + y);
		glVertex2i(xc + x, yc - y);
		glVertex2i(xc - x, yc - y);
	}
	glEnd();
	return;
}


//Thuật toán MidPoint vẽ hình tròn
void DrawCircle(int xc, int yc, int r)
{
	glColor3b(1, 0, 0);
	glBegin(GL_POINTS);
	int x = 0; int y = r;
	int f = 1 - r;
	glVertex2i(x, y);
	while (x < y)
	{
		if (f < 0)
		{
			f += 2 * x + 3;
		}
		else
		{
			f += 2 * (x - y) + 5;
			y--;
		}
		x++;
		glVertex2i(x + xc, y + yc);
		glVertex2i(-x + xc, y + yc);
		glVertex2i(x + xc, -y + yc);
		glVertex2i(-x + xc, -y + yc);
		glVertex2i(y + xc, x + yc);
		glVertex2i(-y + xc, x + yc);
		glVertex2i(y + xc, -x + yc);
		glVertex2i(-y + xc, -x + yc);
	}
	glEnd();
	return;
}
void Display(void)
{
	glClear(GL_COLOR_BUFFER_BIT);
	//BrePoint(150, 100, 300, 170);//thuật toán Bresenham vẽ đường thẳng
	//Midpoint(150, 30, 300, 100); // thuật toán MidPoint vẽ đường thẳng
	//BreElip(-300, 100, 50, 100); // thuật toán Bresenham vẽ hình elip
	DrawElip(-150, 100, 50, 100);//thuật toán MidPoint vẽ hình elip
	//DrawCircle(20, 50, 100);//thuật toán MidPoint vẽ hình tròn
	//BresCircle(20, 50, 100);//thuật toán Bresenham vẽ hình tròn
	glFlush();
	return;
}

int main(int argc, char* argv[])
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowPosition(50, 50);
	glutInitWindowSize(width, height);
	glutCreateWindow("Computers Graphics With OpenGL");
	Init();
	glutDisplayFunc(Display);
	glutMainLoop();
	return 0;
}
