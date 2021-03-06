package com.aspose.cloud.cells;

import java.util.List;

public class WorksheetProtectionRequest {
	private boolean allowDeletingColumn;
	public boolean getAllowDeletingColumn(){return allowDeletingColumn;}
	public void setAllowDeletingColumn(boolean allowDeletingColumn){this.allowDeletingColumn=allowDeletingColumn;}

	private boolean allowDeletingRow;
	public boolean getAllowDeletingRow(){return allowDeletingRow;}
	public void setAllowDeletingRow(boolean allowDeletingRow){this.allowDeletingRow=allowDeletingRow;}

	private List<String> allowEditArea;
	public List<String> getAllowEditArea(){return allowEditArea;}
	public void setAllowEditArea(List<String> allowEditArea){this.allowEditArea=allowEditArea;}

	private boolean allowFiltering;
	public boolean getAllowFiltering(){return allowFiltering;}
	public void setAllowFiltering(boolean allowFiltering){this.allowFiltering=allowFiltering;}

	private boolean allowFormattingCell;
	public boolean getAllowFormattingCell(){return allowFormattingCell;}
	public void setAllowFormattingCell(boolean allowFormattingCell){this.allowFormattingCell=allowFormattingCell;}

	private boolean allowFormattingColumn;
	public boolean getAllowFormattingColumn(){return allowFormattingColumn;}
	public void setAllowFormattingColumn(boolean allowFormattingColumn){this.allowFormattingColumn=allowFormattingColumn;}

	private boolean allowFormattingRow;
	public boolean getAllowFormattingRow(){return allowFormattingRow;}
	public void setAllowFormattingRow(boolean allowFormattingRow){this.allowFormattingRow=allowFormattingRow;}

	private boolean allowInsertingColumn;
	public boolean getAllowInsertingColumn(){return allowInsertingColumn;}
	public void setAllowInsertingColumn(boolean allowInsertingColumn){this.allowInsertingColumn=allowInsertingColumn;}

	private boolean allowInsertingHyperlink;
	public boolean getAllowInsertingHyperlink(){return allowInsertingHyperlink;}
	public void setAllowInsertingHyperlink(boolean allowInsertingHyperlink){this.allowInsertingHyperlink=allowInsertingHyperlink;}

	private boolean allowInsertingRow;
	public boolean getAllowInsertingRow(){return allowInsertingRow;}
	public void setAllowInsertingRow(boolean allowInsertingRow){this.allowInsertingRow=allowInsertingRow;}

	private boolean allowSelectingLockedCell;
	public boolean getAllowSelectingLockedCell(){return allowSelectingLockedCell;}
	public void setAllowSelectingLockedCell(boolean allowSelectingLockedCell){this.allowSelectingLockedCell=allowSelectingLockedCell;}

	private boolean allowSelectingUnlockedCell;
	public boolean getAllowSelectingUnlockedCell(){return allowSelectingUnlockedCell;}
	public void setAllowSelectingUnlockedCell(boolean allowSelectingUnlockedCell){this.allowSelectingUnlockedCell=allowSelectingUnlockedCell;}

	private boolean allowSorting;
	public boolean getAllowSorting(){return allowSorting;}
	public void setAllowSorting(boolean allowSorting){this.allowSorting=allowSorting;}

	private boolean allowUsingPivotTable;
	public boolean getAllowUsingPivotTable(){return allowUsingPivotTable;}
	public void setAllowUsingPivotTable(boolean allowUsingPivotTable){this.allowUsingPivotTable=allowUsingPivotTable;}

	private String password;
	public String getPassword(){return password;}
	public void setPassword(String Password){this.password=Password;}

	private String protectionType;
	public String getProtectionType(){return protectionType;}
	public void setProtectionType(String protectionType){this.protectionType=protectionType;}

}
