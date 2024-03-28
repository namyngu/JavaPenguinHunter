import java.util.Objects;
import java.util.Scanner;
import java.io.*;
/**
 *Class that can read/write to a file.
 *@author Hoang Nguyen
 *@version v1.0.0
 */
public class FileIO
{
    private final String outputFile;

    /**
     *Default constructor will output a file called 'Results.txt' when writing.
     */
    public FileIO()
    {
        outputFile = "Results.txt";
    }

    /**
     *Non-default constructor will output a file with the specified file name when writing.
     *@param fileName        Accepts a string to specify the output filename.
     */
    public FileIO(String fileName)
    {
        outputFile = fileName;
    }

    /**
     *Method that reads from a file and outputs it as a string.
     *@param inputFile       Name of file to be read as a string.
     *@return        Returns the contents of the file read as a string.
     *@throws IllegalArgumentException       If it cannot find a 'weapons.txt' file in the same directory.
     */
    public String readFile(String inputFile)
    {
        StringBuilder contents = new StringBuilder();
        if (inputFile.equals("src/weapons.txt"))
        {
            try (FileReader reader = new FileReader(inputFile))
            {
                Scanner console = new Scanner(reader);
                while (console.hasNextLine())
                {
                    contents.append(console.nextLine()).append("\n");
                }
                reader.close();
            }
            catch (Exception e)
            {
                System.out.println("Error cannot read file.");
            }
        }
        else
            throw new IllegalArgumentException ("Cannot find 'weapons.txt' file");
        return contents.toString();
    }

    /**
     *Method that writes from the specified String and write to a specified filename in the constructor.
     *@param contents        A string passed in as parameters to be written from.
     */
    public void writeFile(String contents)
    {
        try (FileWriter writer = new FileWriter(outputFile))
        {
            if (!outputFile.trim().isEmpty())
            {
                writer.write(contents);
                writer.close();
            }
            else
                System.out.println("Invalid filename");
        }
        catch (Exception e)
        {
            System.out.println("Error failed to write to file.");
        }
    }
}