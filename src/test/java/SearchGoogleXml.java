import org.testng.TestNG;
import org.testng.annotations.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchGoogleXml {

    public String xmlMyGreatProperty;

    @BeforeSuite
    @Parameters({"xmlMyGreatProperty"})
    public void set(@Optional String xmlMyGreatProperty) {
        this.xmlMyGreatProperty = xmlMyGreatProperty;
    }


    @Test(dataProvider = "searchString")
    public void runXMLsuite(String mySearch) {
        TestNG testNG = new TestNG();
        File file = new File("xmls/SimpleTest.xml");
        Map<String, String> params = new HashMap<>();
        params.put("myGreatProperty", mySearch);
        XmlSuite xmlSuite = new XmlSuite();
        List<String> fileList = new ArrayList<>();
        fileList.add(file.getAbsolutePath());
        xmlSuite.setSuiteFiles(fileList);
        xmlSuite.setParameters(params);
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(xmlSuite);
        testNG.setXmlSuites(suites);
        testNG.run();
    }

    @DataProvider(name = "searchString", parallel = true)
    public Object[][] getSearch(){
        return new Object[][]{
                {"test"},
                {"Киев"},
                {"TestNG"}
        };
    }
}
