import org.omg.PortableServer.POA;

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
        int maxLength = 0;

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
                        int length = 1;
                        while((p = linkList.removeFirst()) != null){
                            boolean isAdd = judge(grid, tmp, p.x, p.y-1, linkList, tmpList, a, b);
                            length += isAdd?1:0;
                            isAdd = judge(grid, tmp, p.x, p.y+1, linkList, tmpList, a, b);
                            length += isAdd?1:0;
                            isAdd = judge(grid, tmp, p.x-1, p.y, linkList, tmpList, a, b);
                            length += isAdd?1:0;
                            isAdd = judge(grid, tmp, p.x+1, p.y, linkList, tmpList, a, b);
                            length += isAdd?1:0;
                        }
                         if(length > maxLength){
                            maxLength = length;
                         }
                         for(Point point :tmpList){
                             tmp[point.x][point.y] = -1;
                         }
                         tmpList.clear();

                    }
                }
            }
        }

        return maxLength;
    }

    private boolean judge(int[][] grid, int[][] tmp, int x, int y, List<Point> linkList, List<Point> tmpList, int a, int b){
        if(x > a-1 || y > b-1 || x<0 ||y <0){
            return false;
        }
        if(grid[x][y] == 1 && tmp[x][y] != -1){
            Point tPoint = new Point(x, y-1);
            linkList.add(tPoint);
            tmpList.add(tPoint);
            return true;
        }
        return false;
    }

}
