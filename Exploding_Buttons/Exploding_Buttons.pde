PImage img;
int cellSize=2;
int cols,rows;
void setup(){
  size(400,400,P3D);
  img=loadImage("img.jpg");
  cols=width/cellSize;
  rows=height/cellSize;
  
}


void draw(){
  background(0);
  loadPixels();
  for(int i=0;i<cols;i++){
    for(int j=0;j<rows;j++){
      int x=i*cellSize+cellSize/2;
      int y=j*cellSize+cellSize/2;
      int loc = x + y*width;
      color c = img.pixels[loc];
    }
  }
}