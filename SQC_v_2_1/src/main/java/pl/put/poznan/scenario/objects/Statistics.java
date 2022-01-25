package pl.put.poznan.scenario.objects;

public class Statistics {
    private Integer countAllSteps;
    private Integer countStepsForNoKeyword;
    private Integer countStepsForNoActor;
    private Integer scenarioPrinter;
    private Integer findStepsWithKeywords;

    public void incrementCountAllSteps() {
        this.countAllSteps++;
    }
    public Integer getCountAllSteps() {
        return this.countAllSteps;
    }
    public void resetCountAllSteps(){
        this.countAllSteps = 0;
    }

    public void incrementCountStepsForNoKeyword() {
        this.countStepsForNoKeyword++;
    }
    public Integer getCountStepsForNoKeyword() {
        return this.countStepsForNoKeyword;
    }
    public void resetCountStepsForNoKeyword(){
        this.countStepsForNoKeyword = 0;
    }

    public void incrementCountStepsForNoActor() {
        this.countStepsForNoActor++;
    }
    public Integer getCountStepsForNoActor() {
        return this.countStepsForNoActor;
    }
    public void resetCountStepsForNoActor(){
        this.countStepsForNoActor = 0;
    }

    public void incrementScenarioPrinter() {
        this.scenarioPrinter++;
    }
    public Integer getScenarioPrinter() {
        return this.scenarioPrinter;
    }
    public void resetScenarioPrinter(){
        this.scenarioPrinter = 0;
    }

    public void incrementFindStepsWithKeywords() {
        this.findStepsWithKeywords++;
    }
    public Integer getFindStepsWithKeywords() {
        return this.findStepsWithKeywords;
    }
    public void resetFindStepsWithKeywords(){
        this.findStepsWithKeywords = 0;
    }
    public void printAllStats(){
        Integer s1 = getCountAllSteps();
        Integer s2 = getCountStepsForNoKeyword();
        Integer s3 = getCountStepsForNoActor();
        Integer s4 = getScenarioPrinter();
        Integer s5 = getFindStepsWithKeywords();
        System.out.println("STATISTICS - number of function calls");
        System.out.println("CountAllSteps: \t\t\t\t"+s1);
        System.out.println("CountStepsForNoKeyword: \t"+s2);
        System.out.println("CountStepsForNoActor: \t\t"+s3);
        System.out.println("ScenarioPrinter: \t\t\t"+s4);
        System.out.println("FindStepsWithKeywords: \t\t"+s5);

    }
    public void initializeStats(){
        resetCountAllSteps();
        resetCountStepsForNoKeyword();
        resetCountStepsForNoActor();
        resetScenarioPrinter();
        resetFindStepsWithKeywords();
    }
}
