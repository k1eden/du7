import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

public class DuMethods {
    private Boolean cFlag = false;
    private Boolean hFlag = false;
    private Boolean siFlag = false;
    public HashMap<String, Long> nameSize = new HashMap<String, Long>();

    void parser(String[] args) {
        if (args[0].equals("du")) {
            for (String i : args) {
                if (i.equals("[-h]")) this.hFlag = true; else
                if (i.equals("[-c]")) this.cFlag = true; else
                if (i.equals("[--si]")) this.siFlag = true; else
                if (!i.equals("du")) this.nameSize.put(i, 0L);
            }
        } else throw new IllegalArgumentException("please start your request with 'du'");
    }

    void size() throws URISyntaxException {
        for (String name : nameSize.keySet()) {
            URL res = getClass().getClassLoader().getResource("Котики/" + name);
            File testFile = Paths.get(res.toURI()).toFile();
            if (testFile.exists())
                this.nameSize.put(name,(long) testFile.length());
        }
    }


    void output() {
        int base;
        double sum = 0;
        if (!this.siFlag) base = 1024;
        else base = 1000;
        int baseSqr = base * base;
        int baseCube = base * base * base;
        if (getHFlag()) {
            for (long size : this.nameSize.values()) {
                if (size < base) System.out.println(size + " b");
                else if (size < baseSqr) System.out.println((double) size / base + " kb");
                else if (size < baseCube) System.out.println((double) size / baseSqr + " mb");
                else if (size >= baseCube) System.out.println((double) size / baseCube + " gb");
                sum += size;
            }
        } else
            for (long size : this.nameSize.values()) {
                System.out.println((double) size / base);
                sum += size;
            }
        if (getCFlag()) {
            if (getHFlag()) {
                if (sum < base) System.out.println(sum + " b");
                else if (sum < baseSqr) System.out.println(sum / base + " kb");
                else if (sum < baseCube) System.out.println(sum / baseSqr + " mb");
                else if (sum >= baseCube) System.out.println(sum / baseCube + " gb");
            } else System.out.println(sum / base);
        }
    }

     public Boolean getCFlag() {
         return cFlag;
     }

     public Boolean getHFlag() {
         return hFlag;
     }

     public Boolean getSiFlag() {
         return siFlag;
     }
 }