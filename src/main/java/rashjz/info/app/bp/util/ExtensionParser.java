/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.util;

/**
 *
 * @author rasha_000
 */
public class ExtensionParser {

    public static String getExt(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
//        System.out.println(i);
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
}
