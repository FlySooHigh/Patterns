package decorator;

public interface DataSource {
    void writeDataToFile(String data);
    String readDataFromFile();
}
