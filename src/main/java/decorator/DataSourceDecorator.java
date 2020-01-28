package decorator;

public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeDataToFile(String data) {
        wrappee.writeDataToFile(data);
    }

    @Override
    public String readDataFromFile() {
        return wrappee.readDataFromFile();
    }
}
