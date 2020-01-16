import java.util.Random;

public class DNA {
    int lengthDNA;
    char [] word;
    double fitness;
    Random rn=new Random();
    DNA(int size) {
        this.lengthDNA = size;
        this.word = new char[this.lengthDNA];
        this.fitness = 0.0;
        int  c;
        for (int i = 0; i < lengthDNA; i++) {
            c = rn.nextInt(60) + '?';
            if(c==63)c=32;
            if(c==64)c=46;
            word[i] = (char) (c);
        }
    }


}
