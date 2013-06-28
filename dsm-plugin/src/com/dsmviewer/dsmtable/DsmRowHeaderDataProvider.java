package com.dsmviewer.dsmtable;

import java.text.MessageFormat;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;

import com.dsmviewer.Activator;
import com.dsmviewer.dsm.DependencyMatrix;
import com.dsmviewer.logging.Logger;

/**
 * 
 * @author <a href="mailto:Daniil.Yaroslavtsev@gmail.com"> Daniil Yaroslavtsev</a>
 */
public class DsmRowHeaderDataProvider implements IDataProvider {

    @SuppressWarnings("unused")
    private Logger logger = Activator.getLogger(getClass());

    private DependencyMatrix dsMatrix;
    private List<String> displayNames;

    public DsmRowHeaderDataProvider(DependencyMatrix dsMatrix) {
        this.dsMatrix = dsMatrix;
    }

    @Override
    public int getColumnCount() {
        return dsMatrix == null ? 0 : 1;
    }

    @Override
    public Object getDataValue(int columnIndex, int rowIndex) {
        return dsMatrix == null ? "" : MessageFormat.format("{0} {1}",
                String.valueOf(rowIndex + 1), displayNames.get(rowIndex));
    }

    @Override
    public int getRowCount() {
        return dsMatrix == null ? 0 : dsMatrix.getSize();
    }

    @Override
    public void setDataValue(int i, int j, Object value) {
        // do nothing
    }

    public void setDsMatrix(DependencyMatrix dsMatrix) {
        this.dsMatrix = dsMatrix;
        displayNames = dsMatrix.getDisplayNames();
    }

    public DependencyMatrix getDsMatrix() {
        return dsMatrix;
    }

}