package com.aspose.cloud.cells;

    /// <summary>
    ///  Represents response from the worksheet resource
    /// </summary>
    public class WorksheetResponse extends com.aspose.cloud.common.BaseResponse
    {
       
        private AutoShapesResponse autoShapes;
        private CellsResponse cells;
        private ChartsResponse charts;
        private CommentsResponse comments;
        private ConditionalFormattingResponse conditionalFormattings;
        private HyperlinksResponse hyperlinks;
        private MergedCellsResponse mergedCells;
        private OleObjectsResponse oleObjects;
        private PicturesResponse pictures;
        private LinkResponse link;
        private ValidationsResponse validations;
        private RowsResponse rows;
        private ColumnsResponse columns;
        private Worksheet worksheet;

        public AutoShapesResponse getAutoShapes(){return autoShapes;}
        public CellsResponse getCells(){return cells;}
        public ChartsResponse getCharts(){return charts;}
        public CommentsResponse getComments(){return comments;}
        public ConditionalFormattingResponse getConditionalFormattings(){return conditionalFormattings;}
        public HyperlinksResponse getHyperlinks(){return hyperlinks;}
        public MergedCellsResponse getMergedCells(){return mergedCells;}
        public OleObjectsResponse getOleObjects(){return oleObjects;}
        public PicturesResponse getPictures(){return pictures;}
        public LinkResponse getlink(){return link;}
        public ValidationsResponse getValidations(){return validations;}
        public RowsResponse getRows(){return rows;}
        public ColumnsResponse getColumns(){return columns;}
        public Worksheet getWorksheet(){return worksheet;}
    }