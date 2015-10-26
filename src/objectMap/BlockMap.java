package objectMap;

import java.awt.Graphics2D;
import java.awt.Point;

import main.Game;

public class BlockMap {
	
	private Block[][] map;
	private Object[][] objects;
	double zoom;
	int size;
	
	Point viewPosition;
	

	public BlockMap(){
		map = new Block[100][100];
		objects = new Object[100][100];
		size = Game.HEIGHT/100;
		zoom = 1;
		viewPosition = new Point(0,0);
	}

	public void loadMap(){
		
		for (int x = 0; x < map.length; x++){
			for (int y = 0; y < map[0].length; y++){
				map[x][y] = new Block(0, true);
			}
			
		}
		
		for (int x = 0; x < objects.length; x++){
			for (int y = 0; y < objects[0].length; y++){
				objects[x][y] = new Object(0, 0, true);
			}
		}
		
	}
	
	public void draw(Graphics2D g){
		
		int blockSize = size;
		
		for (int x = 0; x < map.length; x++){
			for (int y = 0; y < map[0].length; y++){
				map[x][y].draw(g, (x * blockSize) - viewPosition.x, (y * blockSize) - viewPosition.y, blockSize);
			}
			
		}
		
//		for (int x = 0; x < objects.length; x++){
//			for (int y = 0; y < objects[0].length; y++){
//				objects[x][y].draw(g, (x * blockSize) - viewPosition.x, (y * blockSize) - viewPosition.y, blockSize);
//			}
//			
//		}
	}
	
	public void fixBounds(){
		if (viewPosition.x > Game.WIDTH/2){
			viewPosition.x = Game.WIDTH/2;
		}
		if (viewPosition.x + (size * 100) < Game.WIDTH/2){
			viewPosition.x = (Game.WIDTH/2) - (size * 100);
		}
		if (viewPosition.y > Game.HEIGHT/2){
			viewPosition.y = Game.HEIGHT/2;
		}
		if (viewPosition.y + (size * 100) < Game.HEIGHT/2){
			viewPosition.y = (Game.HEIGHT/2) - (size * 100);
		}
		if (size > 30){
			size = 30;
		}
	}
	
	public void place(int x, int y , int id){
		int blockSize = (int) (size * zoom);
		map[(int) ((x + viewPosition.x)/blockSize)][(int) ((y + viewPosition.y)/blockSize)].setId(1);
	}
	
	///////GETTERS AND SETTERS////////
	


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	
	public Point getViewPosition() {
		return viewPosition;
	}

	public void setViewPosition(Point viewPosition) {
		this.viewPosition = viewPosition;
	}


	
	
	
	

}
