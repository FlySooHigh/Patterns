package decorator;

public class Demo {
    private static final String COMBINED_DECORATOR_FILENAME = "result4.txt";
    private static final String COMPRESSION_DECORATOR_FILENAME = "result3.txt";
    private static final String ENCRYPTION_DECORATOR_FILENAME = "result2.txt";
    private static final String BASIC_DECORATOR_FILENAME = "result1.txt";
    private static final String FILE_DATASOURCE_FILENAME = "result.txt";

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        CompressionDecorator combinedDecorator = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource(COMBINED_DECORATOR_FILENAME)));

        combinedDecorator.writeDataToFile(salaryRecords);
        DataSource plain = new FileDataSource(COMBINED_DECORATOR_FILENAME);
        System.out.println("----- [CombinedDecoratorOutput Encoded] -----");
        System.out.println(plain.readDataFromFile());
        System.out.println("----- [CombinedDecoratorOutput Decoded] -----");
        System.out.println(combinedDecorator.readDataFromFile());
        System.out.println();

        CompressionDecorator compressionDecorator = new CompressionDecorator(
                new FileDataSource(COMPRESSION_DECORATOR_FILENAME));

        compressionDecorator.writeDataToFile(salaryRecords);
        System.out.println("----- [CompressionDecoratorOutput Encoded] -----");
        plain = new FileDataSource(COMPRESSION_DECORATOR_FILENAME);
        System.out.println(plain.readDataFromFile());
        System.out.println("----- [CompressionDecoratorOutput Decoded] -----");
        System.out.println(compressionDecorator.readDataFromFile());
        System.out.println();

        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(
                new FileDataSource(ENCRYPTION_DECORATOR_FILENAME));

        encryptionDecorator.writeDataToFile(salaryRecords);
        System.out.println("----- [EncryptionDecoratorOutput Encoded] -----");
        plain = new FileDataSource(ENCRYPTION_DECORATOR_FILENAME);
        System.out.println(plain.readDataFromFile());
        System.out.println("----- [EncryptionDecoratorOutput Decoded] -----");
        System.out.println(encryptionDecorator.readDataFromFile());
        System.out.println();

        DataSourceDecorator basicDecorator = new DataSourceDecorator(
                new FileDataSource(BASIC_DECORATOR_FILENAME));

        basicDecorator.writeDataToFile(salaryRecords);
        System.out.println("----- [BasicDecoratorOutput] -----");
        System.out.println(basicDecorator.readDataFromFile());
        System.out.println();

        FileDataSource fileDataSource = new FileDataSource(FILE_DATASOURCE_FILENAME);

        fileDataSource.writeDataToFile(salaryRecords);
        System.out.println("----- [FileDataSourceOutput] -----");
        System.out.println(fileDataSource.readDataFromFile());
        System.out.println();

//        DataSourceDecorator encoded = new CompressionDecorator(
//                new EncryptionDecorator(
//                        new FileDataSource("out/OutputDemo.txt")));
//        encoded.writeData(salaryRecords);
//        DataSource plain = new FileDataSource("out/OutputDemo.txt");
//
//        System.out.println("- Input ----------------");
//        System.out.println(salaryRecords);
//        System.out.println("- Encoded --------------");
//        System.out.println(plain.readData());
//        System.out.println("- Decoded --------------");
//        System.out.println(encoded.readData());
    }
}
