public class Average {
    private Integer count;
    private Double value;

    public Average()
    {
        count = 0;
        value = 0.0;
    }

    public void addSample(Double value)
    {
        this.value += value;
        this.count++;
    }

    public Double getAverage()
    {
        return value / count;
    }
}
