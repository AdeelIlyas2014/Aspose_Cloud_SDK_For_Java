package com.aspose.cloud.cells;
import java.lang.String;

public class MoveWorksheet
    {
        public MoveWorksheet()
        { 
        
        }

        private String destinationWorksheet;
        private Position position;   
        
        public String getDestinationWorksheet(){return destinationWorksheet;}
        public Position getPosition(){return position;}
        
        public void setDestinationWorksheet(String DestinationWorksheet){ this.destinationWorksheet=DestinationWorksheet;}
        public void setPosition(Position Position){ this.position=Position;}

    }