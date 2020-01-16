import java.util.ArrayList;
import java.util.Random;

public class Population {

    int num;
    DNA fittest;
    double mutation;
    String target;
    ArrayList<DNA> population=new ArrayList<>();
    Random rn=new Random();

    Population(int num,double m,String t){
        this.num=num;
        this.mutation=m;
        this.target=t;
        for(int i=0;i<num;i++){
            population.add(new DNA(target.length()));
        }
        this.fittest=new DNA(target.length());
    }

    void calculateFitness(){
        fittest.fitness=Integer.MIN_VALUE;

        for(int i=0;i<num;i++){
            for(int j=0;j<target.length();j++){
                if(population.get(i).word[j]==target.charAt(j)){
                    population.get(i).fitness++;
                }
            }
            //Evaluating fitness in to %
            //Marking the fittest String
            if(population.get(i).fitness>fittest.fitness){
                fittest=population.get(i);
            }

        }
    }
    void createNewGeneration(){
        ArrayList<DNA> matingpool=new ArrayList<>();
        for(int i=0;i<num;i++){
            for(int j=0;j<population.get(i).fitness;j++){
                matingpool.add(population.get(i));
            }
        }

        for(int i=0;i<this.population.size();i++){
            int a = (int)Math.floor(rn.nextDouble()*matingpool.size());
            int b = (int)Math.floor(rn.nextDouble()*matingpool.size());
            DNA ParentA=matingpool.get(a);
            DNA ParentB=matingpool.get(b);
            DNA child=crossover(ParentA,ParentB);
            child=mutate(child);
            population.set(i,child);
        }


    }

    DNA crossover(DNA ParentA,DNA ParentB){
        int half = ParentA.word.length/2;
        DNA child=new DNA(target.length());
        for(int i=0;i<half;i++){
            child.word[i]=ParentA.word[i];
        }
        for (int i=half;i<target.length();i++)
            child.word[i]=ParentB.word[i];
        return child;
    }

    DNA mutate(DNA element){
        int c;
        for(int i=0;i<element.word.length;i++){
            if(rn.nextDouble()<this.mutation)
            {
                c = rn.nextInt(60) + '?';
                if(c==63)c=32;
                if(c==64)c=46;
                element.word[i]=(char) (c);
            }

        }
        return element;
    }

}
