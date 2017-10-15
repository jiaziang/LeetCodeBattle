import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaziang on 2017/10/15.
 */
public class MaxIsland {
    public static void main(String[] args){

    }

    public int maxAreaOfIsland(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int length = 0;

        int tmp[][] = new int[a][b];
        LinkedList<Point> linkList = new LinkedList<>();
        ArrayList<Point> tmpList = new ArrayList<>();
        for(int i = 0; i <a ; i++){
            for(int j = 0; j<b; j++){
                int value = grid[i][j];
                int tmpValue = tmp[i][j];
                if(tmpValue == 0){
                    if(value == 0){
                        tmp[i][j] = -1;
                    }
                    else{
                        Point rPoint = new Point(i,j);
                        linkList.add(rPoint);
                        tmpList.add(rPoint);
                        Point p ;
                        length = 1;
                        while((p = linkList.removeFirst()) != null){
                            int x = p.x;
                            int y = p.y;
                            if(grid[x][y-1] == 1 && tmp[x][y-1] != -1){
                                length ++;
                                Point tPoint = new Point(x, y-1);
                                linkList.add(tPoint);
                                tmpList.add(tPoint);
                            }

                        }
                    }
                }


            }
        }


        return length;
    }

}
