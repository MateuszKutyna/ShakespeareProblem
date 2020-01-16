public class Demo {

    static boolean isFinished(char[] tab1,char[] tab2){
        boolean isFinised=false;
        int count=0;
        for(int i=0;i<tab1.length;i++){
            if(tab1[i]==tab2[i])count++;
        }
        if(count==tab1.length)isFinised=true;

        return isFinised;
    }

    public static void main(String[] args){
          String target="PSI jest super";
          int population = 10000;
          double mutation=0.01;
          int generation=0;
          Population pop=new Population(population,mutation,target);
          pop.calculateFitness();
          while(!isFinished(pop.fittest.word,target.toCharArray())){
              pop.createNewGeneration();
              for(int i=0;i<target.length();i++)
                  System.out.print(pop.fittest.word[i]);
              System.out.println(" "+pop.fittest.fitness);
              pop.calculateFitness();
              generation++;
          }
        System.out.println("Number of generations: "+generation);
        for(int i=0;i<target.length();i++)
            System.out.print(pop.fittest.word[i]);
        System.out.println(" "+pop.fittest.fitness);
    }

}
