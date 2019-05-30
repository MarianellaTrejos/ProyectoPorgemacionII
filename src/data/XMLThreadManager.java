
package data;

import domain.Circle;
import domain.Point;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import threads.CircleThread;
import threads.CircleThread1;
import threads.CircleThread2;
import threads.CircleThread3;
import threads.CircleThread4;

public class XMLThreadManager {
    
    //variables
    private Document document;
    private Element root;
    private String path;

    public XMLThreadManager(String path) throws IOException, JDOMException {
        //ruta en la que se encuentra el archivo XML
        this.path = path;
        
        File fileThread = new File(path);//esto es solo para hacer validacion
        if(fileThread.exists()){
            //1. EL ARCHIVO YA EXISTE, ENTONCES LO CARGO EN MEMORIA
            
            //toma la estructura de datos y las carga en memoria
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            
            //carga la memoria
            this.document = saxBuilder.build(path);
            this.root = this.document.getRootElement();
        }
        else{
            //2. EL ARCHIVO NO EXISTE, ENTONCES LO CREO Y LUEGO LO CARGO EN MEMORIA
            
            //CREAMOS EL ELEMENTO RAIZ
            this.root = new Element("Circle");
            
            //CREAMOS EL DOCUMENTO
            this.document = new Document(this.root);
            
            //GUARDAMOS EN DISCO DURO
            storeXML();
        }
    }//end constructor
    
    //almacena en disco duro nuestro documento xml en la ruta especificada
    private void storeXML() throws IOException{
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(document, new PrintWriter(path));
    }

    public void insertThread(CircleThread circleThread) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el estudiante
        Element eCircle = new Element("Circle");
        //agregamos atributo
        Element edelaytime= new Element("DelayTime");
       edelaytime.addContent(circleThread.getDelayTime());
        //crear el elemento nombre
        Element eMycircle = new Element("MyCircle");
        eMycircle.addContent(circleThread.getMyCircle());
        
        
        
        //agregar al elemento student el contenido de nombre y nota
        eCircle.addContent(edelaytime);
        eCircle.addContent(eMycircle);
       
        //AGREGAMOS AL ROOT
        this.root.addContent(eCircle);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    
    
    //delete
    public void deleteStudent() throws IOException{
        List elementList = this.root.getChildren();
        elementList.remove(1);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }
    public void insertThread1(CircleThread1 circleThread1) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el estudiante
        Element eCircle = new Element("Circle1");
        //agregamos atributo
        Element edelaytime= new Element("DelayTime");
       edelaytime.addContent(circleThread1.getDelayTime());
        //crear el elemento nombre
        Element eMycircle = new Element("MyCircle");
        eMycircle.addContent(circleThread1.getMyCircle1());
        
        
        
        //agregar al elemento student el contenido de nombre y nota
        eCircle.addContent(edelaytime);
        eCircle.addContent(eMycircle);
       
        //AGREGAMOS AL ROOT
        this.root.addContent(eCircle);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    public void insertThread2(CircleThread2 circleThread2) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el estudiante
        Element eCircle = new Element("Circle2");
        //agregamos atributo
        Element edelaytime= new Element("DelayTime");
       edelaytime.addContent(circleThread2.getDelayTime());
        //crear el elemento nombre
        Element eMycircle = new Element("MyCircle");
        eMycircle.addContent(circleThread2.getMyCircle2());
        
        
        
        //agregar al elemento student el contenido de nombre y nota
        eCircle.addContent(edelaytime);
        eCircle.addContent(eMycircle);
       
        //AGREGAMOS AL ROOT
        this.root.addContent(eCircle);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    public void insertThread3(CircleThread3 circleThread3) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el estudiante
        Element eCircle = new Element("Circle3");
        //agregamos atributo
        Element edelaytime= new Element("DelayTime");
       edelaytime.addContent(circleThread3.getDelayTime());
        //crear el elemento nombre
        Element eMycircle = new Element("MyCircle");
        eMycircle.addContent(circleThread3.getMyCircle3());
        
        
        
        //agregar al elemento student el contenido de nombre y nota
        eCircle.addContent(edelaytime);
        eCircle.addContent(eMycircle);
       
        //AGREGAMOS AL ROOT
        this.root.addContent(eCircle);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    
    public void insertThread4(CircleThread4 circleThread4) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el estudiante
        Element eCircle = new Element("Circle4");
        //agregamos atributo
        Element edelaytime= new Element("DelayTime");
       edelaytime.addContent(circleThread4.getDelayTime());
        //crear el elemento nombre
        Element eMycircle = new Element("MyCircle");
        eMycircle.addContent(circleThread4.getMyCircle4());
        
        
        
        //agregar al elemento student el contenido de nombre y nota
        eCircle.addContent(edelaytime);
        eCircle.addContent(eMycircle);
       
        //AGREGAMOS AL ROOT
        this.root.addContent(eCircle);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    
    
    
    
//    metodo para obtener todos los estudiantes en un arreglo
//    public Circle[] getAllThreads(){
//        //obtenemos la cantidad de estudiantes
//        int CirclesQuantity = this.root.getContentSize();
//        Circle c = new Circle();
//        //obtenemos una lista con todos los elementos de root
//        List elementList = this.root.getChildren();
//        
//        //definimos el tamanno del arreglo
//        Circle[] CircleArray = new Circle[CirclesQuantity];
//        
//        //recorremos la lista para ir creando los objetos de tipo estudiante
//        int count = 0;
//        for(Object currentObject: elementList){
//            //transformo el object
//            Element currentElement = (Element)currentObject;
//            
//            //crear el estudiante
//            Circle currentCircle = new Circle();
//            Point pointPosition = null;
//////            //establezco el id
//            currentCircle.setPointPosition1(pointPosition);
//                    currentElement.getAttributeValue("pointPosition");
//            
//            //establezco el nombre
//            currentCircle.setIdentification(currentElement.getChild("identification").getValue());
//            
//            //establezco la nota
//          
//            currentElement.getAttributeValue("Size");
//              currentCircle.setSide(getAllThreads().length);
//            
//                  
//            
//            //guardar en el arreglo
//            CircleArray[count++] = currentCircle;
//        }//end for
//        return CircleArray;
//    }
//    
}
