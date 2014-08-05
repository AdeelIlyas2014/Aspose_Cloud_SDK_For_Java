package com.aspose.cloud.cells;

public class WorkbookResponse extends com.aspose.cloud.common.BaseResponse
    {
        
        private DocumentPropertiesResponse documentProperties;
        private WorksheetsResponse worksheets;
        private NamesResponse names;
        private TextItemsResponse textItems;
        private DocumentProperty documentProperty;
        private Workbook workbook;
        private Worksheet worksheet;
        private Name name;
        private TextItem textItem;
        private Style style;
        
        
        public DocumentPropertiesResponse getDocumentProperties(){return documentProperties;}
        public WorksheetsResponse getWorksheets(){return worksheets;}
        public NamesResponse getNames(){return names;}
        public TextItemsResponse getTextItems(){return textItems;}
        public DocumentProperty getDocumentProperty(){return documentProperty;}
        public Workbook getWorkbook(){return workbook;}
        public Worksheet getWorksheet(){return worksheet;}
        public Name getName(){return name;}
        public TextItem getTextItem(){return textItem;}
        public Style getStyle(){return style;}
    }