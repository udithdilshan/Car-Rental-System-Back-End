package lk.easycarrental.carrentalsystem.utill;

import java.io.File;
import java.net.URISyntaxException;

public class   FileUploadLocations {

   public static String mainUpload=setFileStoreLocation()+"/Upload/";

    public static String setFileStoreLocation() {
        try {
           return mainUpload = new File(FileUploadLocations.class.getProtectionDomain().getCodeSource().getLocation().toURI())
                    .getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static final String CUSTOMER=mainUpload+"Customer/";
    public static final String CUSTOMER_DOWNLOAD_PATH="/Customer/";

}
