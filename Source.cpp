#include <GL/glut.h>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <cstdlib>

struct Point
{
    float x, y, z;
    unsigned char r, g, b, a;
};
std::vector< Point > points;

GLUquadricObj* obj = gluNewQuadric();

GLfloat movebephong = 0;
GLfloat movemay = 0;
GLfloat moveship = 0;
GLfloat movetialua = 0;
GLfloat moverocket = 0;
GLfloat movespace = 0;
GLfloat angle = 0;
GLfloat q = 0.6, o = 0.6, p = 1;
GLfloat movestar = 0;


void tialua()
{

    glTranslatef(0, 0, movetialua);
    // draw
    GLfloat diff2[] = { 1, 1, 1, 1 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diff2);//Tạo ánh sáng khuếch tán cho đối tượng
    glEnableClientState(GL_VERTEX_ARRAY);
    glEnableClientState(GL_COLOR_ARRAY);
    glVertexPointer(3, GL_FLOAT, sizeof(Point), &points[0].x);
    glColorPointer(4, GL_UNSIGNED_BYTE, sizeof(Point), &points[0].r);
    glPointSize(8.0);
    glDrawArrays(GL_POINTS, 0, points.size());
    glTranslatef(0, 0, -movetialua);
}

void tialua2()
{

    glTranslatef(0, 0, movetialua);
    // draw
    GLfloat diff2[] = { 1, 1, 1, 1 };
    
    glVertexPointer(3, GL_FLOAT, sizeof(Point), &points[0].x);
    glColorPointer(4, GL_UNSIGNED_BYTE, sizeof(Point), &points[0].r);
    glPointSize(2);
    glDrawArrays(GL_POINTS, 0, points.size());
    
    glTranslatef(0, 0, -movetialua);
}

void rocket()
{
    //glTranslatef(0, 0, -35);
    //glRotatef(-35, 0, 1, 0);
    GLfloat rocketcolor[] = { 0.7,0.0,0.0,1.0 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, rocketcolor);
    glTranslatef(0, 0, moverocket);
    //ten lua day
    gluCylinder(obj, 6, 5, 5, 100, 100);
    glTranslatef(0, 0, 5);
    gluCylinder(obj, 5, 8, 3, 100, 100);
    glTranslatef(0, 0, 3);
    gluCylinder(obj, 8, 8, 35, 100, 100);
    glTranslatef(0, 0, 35);
    gluCylinder(obj, 8, 2, 5, 100, 100);
    glTranslatef(0, 0, 5);
    gluSphere(obj, 2, 100, 100);
    glTranslatef(0, 0, -48);
    glTranslatef(0, 0, -moverocket);
}

void ship()
{
    GLfloat shipcolor[] = { 0.85,0.9,1,0 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, shipcolor);
    //duoi
    gluCylinder(obj, 1.5, 4, 4, 100, 100);
    glTranslatef(0, 0, 4);
    glDisable(GL_LIGHTING);
    //glTranslatef(0, -10, 0);
    glColor3f(0.9, 0.9, 0.9);
    

    glBegin(GL_QUADS);
    glVertex3f(0.5, 0, 0);
    glVertex3f(0.5, 0, 12);
    glVertex3f(0.1, -10, 4);
    glVertex3f(0.1, -10, 0);
    ////glEnd();
    ////glBegin(GL_QUADS);
    glVertex3f(-0.5, 0, 0);
    glVertex3f(-0.5, 0, 12);
    glVertex3f(-0.1, -10, 4);
    glVertex3f(-0.1, -10, 0);
    ////glEnd();
    ////glBegin(GL_QUADS);
    glVertex3f(-0.1, -10, 4);
    glVertex3f(0.1, -10, 4);
    glVertex3f(0.1, -10, 0);
    glVertex3f(-0.1, -10, 0);
    ////glEnd();
    ////glBegin(GL_QUADS);
    glVertex3f(0.1, -10, 4);
    glVertex3f(-0.1, -10, 4);
    glVertex3f(-0.5, 0, 12);
    glVertex3f(0.5, 0, 12);
    ////glEnd();
    ////glBegin(GL_QUADS);
    glVertex3f(0.1, -10, 0);
    glVertex3f(-0.1, -10, 0);
    glVertex3f(-0.5, 0, 0);
    glVertex3f(0.5, 0, 0);
    glEnd();

    //glTranslatef(0, 12, 0);

    //canh phai
    glBegin(GL_QUADS);
    glVertex3f(0, 0.5, 12);
    glVertex3f(0, 0.5, 0);
    glVertex3f(14, 0.1, 0);
    glVertex3f(14, 0.1, 3);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(0, -0.5, 12);
    glVertex3f(0, -0.5, 0);
    glVertex3f(14, -0.1, 0);
    glVertex3f(14, -0.1, 3);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(0, 0.5, 12);
    glVertex3f(0, -0.5, 12);
    glVertex3f(14, -0.1, 3);
    glVertex3f(14, 0.1, 3);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(14, 0.1, 3);
    glVertex3f(14, -0.1, 3);
    glVertex3f(14, -0.1, 0);
    glVertex3f(14, 0.1, 0);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(14, 0.1, 0);
    glVertex3f(14, -0.1, 0);
    glVertex3f(0, -0.5, 0);
    glVertex3f(0, 0.5, 0);
    glEnd();
    //canh trai
    glBegin(GL_QUADS);
    glVertex3f(0, 0.5, 12);
    glVertex3f(0, 0.5, 0);
    glVertex3f(-14, 0.1, 0);
    glVertex3f(-14, 0.1, 3);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(0, -0.5, 12);
    glVertex3f(0, -0.5, 0);
    glVertex3f(-14, -0.1, 0);
    glVertex3f(-14, -0.1, 3);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(0, 0.5, 12);
    glVertex3f(0, -0.5, 12);
    glVertex3f(-14, -0.1, 3);
    glVertex3f(-14, 0.1, 3);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(-14, 0.1, 3);
    glVertex3f(-14, -0.1, 3);
    glVertex3f(-14, -0.1, 0);
    glVertex3f(-14, 0.1, 0);
    //glEnd();
    //glBegin(GL_QUADS);
    glVertex3f(-14, 0.1, 0);
    glVertex3f(-14, -0.1, 0);
    glVertex3f(0, -0.5, 0);
    glVertex3f(0, 0.5, 0);
    glEnd();
    glEnable(GL_LIGHTING);
    //glTranslatef(0, 0, -5);

    //glTranslatef(0, 0, 3);
    gluCylinder(obj, 4, 4, 25, 100, 100);
    glTranslatef(0, 0, 25);
    gluCylinder(obj, 4, 1, 4, 100, 100);
    glTranslatef(0, 0, 4);
    gluSphere(obj, 1, 100, 100);

    glTranslatef(0, -3.5, -10);
    glScalef(1, 1, 2);
    gluSphere(obj, 2, 100, 100);
    glScalef(1, 1, 0.5);
    glTranslatef(0, 0, -moveship);
}

void thanhcheo()
{
    GLfloat diff2[] = { 0.5, 0.5, 0.5, 0.0 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diff2);

    glRotatef(45, 1, 0, 0);
    gluCylinder(obj, 0.5, 0.5, 10, 100, 100);
    glRotatef(-45, 1, 0, 0);
    glTranslatef(0, -6.5, 0);
    glRotatef(-45, 1, 0, 0);
    gluCylinder(obj, 0.5, 0.5, 10, 100, 100);
    glRotatef(45, 1, 0, 0);

    glRotatef(-90, 1, 0, 0);
    gluCylinder(obj, 0.5, 0.5, 8, 100, 100);
    glRotatef(90, 1, 0, 0);

    glRotatef(-360, 1, 0, 0);
    gluCylinder(obj, 0.5, 0.5, 8, 100, 100);
    glRotatef(360, 1, 0, 0);

    glTranslatef(0, -0.5, 8);
    glRotatef(-90, 1, 0, 0);
    gluCylinder(obj, 0.5, 0.5, 8, 100, 100);
    glRotatef(90, 1, 0, 0);

    glTranslatef(0, 8, 0);
    glRotatef(-180, 1, 0, 0);

    gluCylinder(obj, 0.5, 0.5, 8, 100, 100);
    glRotatef(180, 1, 0, 0);
}

void bephong()
{
    thanhcheo();

    glRotatef(-90, 0, 1, 0);
    glTranslatef(0, -1, 0);
    thanhcheo();
    glTranslatef(0, 1, 0);
    glRotatef(90, 0, 1, 0);

    glRotatef(-180, 0, 1, 0);
    glTranslatef(0, -1.75, 0);
    thanhcheo();
    glTranslatef(0, 1.75, 0);
    glRotatef(180, 0, 1, 0);

    glRotatef(90, 0, 1, 0);
    glTranslatef(0, -2.5, 0);
    thanhcheo();

    glTranslatef(0, -5, -8);
}
void launchers()
{
    glTranslatef(0, 15, 0);
    bephong();
    glTranslatef(0, -5, 0);
    bephong();
    glTranslatef(0, -5, 0);
    bephong();
    glTranslatef(0, -5, 0);
    bephong();
}

void may()
{
    GLfloat maycolor[] = { 0.95, 0.95, 0.95, 0.9 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, maycolor);
    glTranslatef(-35, 30, movemay+100);
    glRotatef(90, 0, 0, 1);
    glScalef(1, 2, 1);
    gluSphere(obj, 8, 100, 100);
    glRotatef(-90, 0, 0, 1);
    glTranslatef(30, 5, 10);
    gluSphere(obj, 6, 100, 100);
    glTranslatef(3, 0, 5);
    gluSphere(obj, 5, 100, 100);
}

void updaterocket()
{
    moverocket -= 0.3;
    if (moverocket < -55)
        moverocket = -55;
    //glutPostRedisplay();
    //glutTimerFunc(100, updaterocket, 0);
}

void updatemay()
{
    movemay -= 0.5;
    if (movemay < -145) movemay = -145;
    moveship += 0.1;
    if (moveship > 15) moveship = 15;
    //glutPostRedisplay();
    //glutTimerFunc(100, updatemay, 0);
}


void updatelauncher()
{
    movebephong -= 0.3;
    if (movebephong < -32) movebephong = -32;
    //glutPostRedisplay();
    //glutTimerFunc(50, updatelauncher, 0);
}


void updatescreen()
{
    q -= 0.0005;
    o -= 0.0005;
    p -= 0.0008;
    movetialua -= 0.3;
    if (q < 0 && o < 0 && p < 0)
    {
        q = 0;
        o = 0;
        p = 0;
    }
    glClearColor(q, o, p, 0);
    if (movetialua < -10) movetialua = 0;
    //glutPostRedisplay();
    //glutTimerFunc(50, updatescreen, 0);
}


void updatestar()
{
    movestar -= 0.05;
    if (movestar < -32) movestar = 0;
    //glutPostRedisplay();
    //glutTimerFunc(50, updatestar, 0);
}

void updateinspace()
{
    movespace += 0.1;
    //if (movespace > 30) movespace = 30;
    angle -= 0.5;
    if (angle < -70) angle = -70;
    //glutTimerFunc(50, updateinspace, 0);
}


void star()
{
    
    glTranslatef(0, 0,movestar);
    //draw
    GLfloat diff2[] = { 0.5, 0.7, 0.6, 1 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diff2);
    
    glVertexPointer(2, GL_FLOAT, sizeof(Point), &points[0].x);
    glColorPointer(4, GL_UNSIGNED_BYTE, sizeof(Point), &points[0].r);
    glPointSize(3.0);
    glDrawArrays(GL_POINTS, 0, points.size());
   

}


void timer(int)
{
    updatescreen();
    updatelauncher();
    if (p <= 0.65)
    {
        updatemay();
    }
    if (p < 0.05 && moverocket > -55)
    {
        updaterocket();
    }
    if (moverocket == -55)
    {
        updateinspace();
        glTranslatef(0, movespace, movespace);
    }
    if (q == 0)
        updatestar();
    glutPostRedisplay();
    glutTimerFunc(20, timer, 0);
}

void RendenScene()//vẽ các đối tượng đồ họa
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();

    gluLookAt(15, -35.0, 60.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    //gluLookAt(-30.0, -15.0, 30.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

    glPushMatrix();
    glEnable(GL_LIGHTING);
    //DrawCoordinate();

    if (movebephong > -32)
    {
        glTranslatef(0, movebephong, 0);

        glTranslatef(-12, -15, 0);
        launchers();
        glTranslatef(27, 14, 0);
        launchers();

        glTranslatef(0, -movebephong, 0);
        glTranslatef(-17.5, 15, 0);
    }
    else
        glTranslatef(-2.5, -14, 0);
    glRotatef(-90, 1, 0, 0);
    glTranslatef(0, 0, moveship);
    glTranslatef(0, 0, -25);
    if (p >= 0)
    {
        if (moverocket != -55)
        {
            rocket();
            if (p > 0.05)
            {
                glTranslatef(2, 0, 0);
                glScalef(0.1, 0.1, 0.1);
                tialua();
                glScalef(10, 10, 10);
                glTranslatef(-2, 0, 0);
            }
        }
    }

    glTranslatef(0, -12, 5);
    if (moverocket == -55)
    {
        //updateinspace();
        glTranslatef(0, movespace, movespace);
        glRotatef(angle, 1, 0, 0);
    }
    if (p == 0)
    {
        glScalef(0.02, 0.02, 0.02);
        tialua2();
        glScalef(50, 50, 50);
    }
    ship();
    glRotatef(-angle, 1, 0, 0);
    glTranslatef(0, -movespace, -movespace);

    if (moverocket == -55)

    glTranslatef(10.5, -15, 20);

    //updatelauncher();
    if (p <= 0.65)
    {
        if (movemay != -145)
        {
            may();
            //updatemay();
        }
    }
    if (q == 0)
    { 
        star();
        glRotatef(90, 1, 0, 0);
        star();
        glRotatef(90, 0, 1, 0);
        star();
        //updatestar();
    }
    //glPopMatrix();
    //glutPostRedisplay();
    glutSwapBuffers();
}

void ReShape(int width, int height)//thiet lap che do view
{
    glViewport(0, 0, width, height);//thiết lập chế độ xem.
    glMatrixMode(GL_PROJECTION);//chi dinh ma tran hiện tại, GL_PROJECTION đê chỉnh hình hoặc chiếu phối cảnh
    glLoadIdentity();/*Ma trận danh tính, về mặt ma trận chiếu và mô hình xem, về cơ bản đặt lại ma trận trở về 
                        trạng thái mặc định.*/
    float ratio = (float)width / (float)height;
    gluPerspective(45.0, ratio, 1, 150.0);//thiết lập ma trận chiếu phối cảnh.
    glMatrixMode(GL_MODELVIEW);//su dụng ma trận chuyển đổi đối tượng
}

void Init()
{

    glClearColor(q, o, p, 0);/*Đặt màu nền với các biến như trên(xanh da trời nhạt)*/

    glEnable(GL_DEPTH_TEST);//kích hoạt so sánh độ sâu và cập nhật bộ đệm độ sâu

    glEnable(GL_LIGHTING); //dùng ánh sáng hiện tại để tính màu
    glEnable(GL_LIGHT0); //kích hoạt chiếu sáng với màu GL_LIGHT0

    GLfloat light_pos[] = { 100, 10, 100, 0 };
    glLightfv(GL_LIGHT0, GL_POSITION, light_pos);	//cài đặt vị trí chiếu sáng và loại ánh sáng

    GLfloat ambient[] = { 1.0, 1.0, 0.0, 1.0 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, ambient);	// Chiếu sáng toàn phần cho đối tượng của vật

    /*GLfloat diff_use[] = { 0.6, 0.7, 0.7, 1.0 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diff_use);*/

    GLfloat specular[] = { 1.0, 1.0, 1.0, 1.0 };
    glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, specular);	// Tạo ánh sáng phản xạ trong đối tượng.

    GLfloat shininess = 15.0f;
    glMateriali(GL_FRONT, GL_SHININESS, shininess);	// Điều chỉnh cường độ điểm chiếu sáng phản xạ.

}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);/* khởi tạo thư viện GLUT và đàm phán một phiên với hệ thống cửa sổ. Trong quá trình này,
                          glutInit có thể khiến chương trình GLUT chấm dứt với thông báo lỗi cho người dùng nếu GLUT
                          không thể được khởi tạo đúng cách*/
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);/* Chế độ hiển thị ban đầu được sử dụng khi tạo các cửa sổ cấp cao
                                                nhất, cửa sổ phụ và lớp phủ để xác định chế độ hiển thị OpenGL cho
                                                cửa sổ hoặc lớp phủ được tạo. GLUT_SINGLE: chế độ đệm đôi; GLUT_RGB: 
                                                chế độ màu RGB.*/
    glutInitWindowSize(1200, 700);/*Kích thước cửa sổ được tạo: chiều rộng 1200px, chiều cao 700px*/
    glutInitWindowPosition(50, 50);/*Vị trí hiển thị cửa sổ tính từ góc trên bên trái màn hình*/
    glutCreateWindow("Mo phong phong tau vu tru");/*Tạo cửa sổ với tiêu đề "Mo phong phong tau vu tru" với kích thước
                                                  và trí như trên*/
    Init();
    glutReshapeFunc(ReShape);/*thiết lập lại cuộc gọi lại cho cửa sổ hiện tại . Gọi lại định hình lại được kích hoạt
                                khi một cửa sổ được định hình lại. Một cuộc gọi lại định hình lại cũng được kích hoạt
                                ngay lập tức trước khi gọi lại hiển thị đầu tiên của cửa sổ sau khi cửa sổ được tạo 
                                hoặc bất cứ khi nào lớp phủ cho cửa sổ được thiết lập. */
    for (size_t i = 0; i < 150; ++i)
    {
        //srand(time(NULL));
        Point pt;
        pt.x = -60 + (rand() % 100);
        pt.y = -60 + (rand() % 100);
        pt.z = -60 + (rand() % 100);
        pt.r = rand() % 255;
        pt.g = rand() % 255;
        pt.b = rand() % 255;
        pt.a = 255;
        points.push_back(pt);
    }
    glutDisplayFunc(RendenScene);//ve các đối tượng hình học
    
    glutTimerFunc(0, timer, 0);
    glutMainLoop();
}