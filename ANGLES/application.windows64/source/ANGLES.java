import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ANGLES extends PApplet {

final int W = 1200;
final int H = 800;
int SCALE = 20;
int cols = W/SCALE;
int rows = H/SCALE;
float[] random = new float[cols+rows*W];
public void settings(){
size(W,H,P2D);
}

public void setup(){
frameRate(144);
for(int i = 1; i < cols; i++){
   for(int j = 1; j < rows; j++){ 
    random[i+j*W] = random(-0.2f,0.2f);
   }
}
}

public void draw(){
background(255);
for(int i = 1; i < cols; i++){
   for(int j = 1; j < rows; j++){  
      float mX = i-mouseX/(SCALE/2);
      float mY = j-mouseY/(SCALE/2);
      PVector mouse = new PVector(mX,mY);
      PVector v = new PVector(i,j);
      float rr = random[i+j*W];
      v.add(mouse);
      PVector loc = new PVector((i/SCALE/2),(j/SCALE/2));
      float disc = PVector.dist(v,loc);
      float dx = disc*0.1f;
      int col = PApplet.parseInt(2.55f*disc);
      push();
      translate(i*SCALE,j*SCALE);
      rotate(v.heading()+PI/4+rr);
      beginShape(TRIANGLES);
      fill(255-col,0,0);
      vertex(0, 2);
      vertex(-(SCALE)+dx, 0);
      vertex(0, -2);
      endShape();
      pop();
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ANGLES" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
