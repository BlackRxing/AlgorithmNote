import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class problem2 {
    static int[] directionx={0,-1,-1,-1,0,1,1,1,0};
    static int[] directiony={0,-1,0,1,1,1,0,-1,-1};
    static  int num=13;
    static double[][] points={{40.71729, -73.996375, 263},
            {40.714067, -73.992939, 295},
            {40.714131, -73.997047, 296},
            {40.714275, -73.9899, 307},
            {40.713079, -73.998512, 308},
            {40.711731, -73.99193, 331},
            {40.71269, -73.987763, 340},
            {40.716021, -73.999744, 355},
            {40.716059, -73.991908, 361},
            {40.710762, -73.994004, 408},
            {40.715815, -73.994224, 412},
            {40.718939, -73.992663, 531},
            {40.711174, -73.996826, 2009}
            };
    static double[][] pointsxy=new double[13][2];
    static HashMap<Point, List<Integer>> map=new HashMap<Point, List<Integer>>();
    public static void main(String[] args) {
        convertLocation(points);
        process();
    }
    //输入：两点a,b的经纬度
    //输出：以米为单位的两点之间的距离
    static double convertDistance(double ax,double ay,double bx,double by){
        double xgap=Math.toRadians(bx)-Math.toRadians(ax);
        double ygap=Math.toRadians(by)-Math.toRadians(ay);
        double distance=Math.pow(Math.sin(ygap/2),2)+Math.cos(Math.toRadians(ay))*Math.cos(Math.toRadians(by))*Math.sin(xgap*xgap/4);
        double r=6371;
        return 1000*r*2*Math.asin(Math.sqrt(distance));
    }
    //将所有经纬度坐标转化为以点集重心点为中心的以米为单位的坐标
    static void  convertLocation(double[][] points){
        double xsum=0;
        double ysum=0;
        for (double[] i:points){
            xsum+=i[1];
            ysum+=i[0];
        }
        double xavg=xsum/num;
        double yavg=ysum/num;
        int t=0;
        for (double[] i:points){
            double x=convertDistance(i[1],i[0],xavg,i[0]);
            pointsxy[t][0]=(i[1]<xavg)?-x:x;
            double y=convertDistance(i[1],i[0],i[1],yavg);
            pointsxy[t][1]=(i[0]<yavg)?-y:y;
            t++;
        }
    }
    //计算i，j两点之间的距离，单位为米
    static double length(int i,int j){
        return Math.sqrt(Math.pow(pointsxy[i][0]-pointsxy[j][0],2)+Math.pow(pointsxy[i][1]-pointsxy[j][1],2));
    }
    //清空hashmap，向内添加序号为0~count的点，方格间隔为step
    static void newHashMap(int count,double step){
        map.clear();
        for(int i=0;i<=count;i++){
            insertMap(i,step);
        }
    }
    //向hashmap中插入序号为i的点
    static void insertMap(int i,double step){
        int[] pos=new int[2];
        pos[0]=(int)(pointsxy[i][0]/step);
        pos[1]=(int)(pointsxy[i][1]/step);
        Point point=new Point((int)(pointsxy[i][0]/step),(int)(pointsxy[i][1]/step));
        System.out.println("x"+point.x+"y"+point.y);
        if(map.containsKey(point)){
            List<Integer> points=(List<Integer>) map.get(point);
            points.add(i);
        }else{
            ArrayList list=new ArrayList<Integer>();
            list.add(i);
            map.put(point,list);
        }

    }
    //扫描该点所在方格和周围共九个方格的所有点，输入最小距离以及点对
    static double[] scan(int i,double step){
        int x=(int)(pointsxy[i][0]/step);
        int y=(int)(pointsxy[i][1]/step);
        int point2=i;
        for(int j=0;j<9;j++){
            int x1=x+directionx[j];
            int y1=y+directiony[j];
            int[] pos={x1,y1};
            Point point=new Point(x1,y1);
            if(map.containsKey(point)){
                for(int k : map.get(point)){
                    if(length(i,k)<step){
                        step=length(i,k);
                        point2=k;
                    }
                }
            }
        }
        return new double[]{step,i,point2};
    }
    //随机选择前两个点的距离为初始间隔，依次加入点并进行扫描，如果该点有更小的间隔则从头更新hashmap，如果没有则直接加入该点，直到所有点加入到hashmap
    static void process(){
        double step=length(0,1);
        System.out.println(step+"step");
        int point1=0,point2=1;
        newHashMap(1,step);
        for(int i=2;i<num;i++){
            double[] res=scan(i,step);
            if(res[0]<step){
                point1=(int) res[1];
                point2=(int) res[2];
                step=res[0];
                newHashMap(i,step);
            }else{
                insertMap(i,step);
            }
        }
        System.out.println((int)points[point1][2]+" "+(int)points[point2][2]+" "+step+" "+((step<=100)?"danger":"safe"));
    }
}
