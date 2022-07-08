import javax.swing.JFrame;
import java.util.Random;

class Yarn implements Runnable{
    private Thread spork;
    private Random rand = new Random();
    private static int loc = 0;
    private static int loc2 = 0;
    private static boolean upDown = true;
    private static boolean leftRight = true;
    public void run(){
        
        if (upDown == true){
            loc2+=10;
            if(loc2==800){
                upDown=false;
            }
        }
        if (leftRight==true){
            loc+=10;
            if (loc==1400){
                leftRight=false;
            }
        }
        if (upDown == false){   
            loc2-=10;
            if(loc2==0){
                upDown=true;
            }
        }
        if (leftRight==false){
            loc-=10;
            if (loc==0){
                leftRight=true;
            }
        }        
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        // frame.setLocation(rand.nextInt(1900), rand.nextInt(1900));
        frame.setLocation(loc, loc2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Example Frame");
        frame.setVisible(true);
        spork = new Thread(this, "spork");
        spork.run();
    }
}
public class FunnyProgram{
    public static void main(String[] args){
        Yarn spork = new Yarn();
        spork.run();
    }
}
