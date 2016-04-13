/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.ntust.ee.ee305.monitoring.motor.service;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceException;
import tw.edu.ntust.ee.ee305.monitoring.motor.embedded.MDESFile;

/**
 *
 * @author D10307009
 */
//@MTOM
//@StreamingAttachment(parseEagerly = true, memoryThreshold = 40000L)
@WebService(serviceName = "MotorService")
public class MotorService {

    @WebMethod
    public void fileUpload(String fileName,
            @XmlMimeType("application/octet-stream") DataHandler data) {
        try {
            System.out.println(fileName);
            MDESFile mdesFile = new MDESFile(data.getInputStream());
            System.out.println(mdesFile);
            mdesFile.print();

        } catch (Exception e) {
            throw new WebServiceException(e);
        }
    }
}
