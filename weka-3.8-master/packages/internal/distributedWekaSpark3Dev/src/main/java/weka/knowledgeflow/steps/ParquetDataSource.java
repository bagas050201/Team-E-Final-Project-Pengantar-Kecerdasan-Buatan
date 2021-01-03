/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 *    CsvDataSource
 *    Copyright (C) 2016 University of Waikato, Hamilton, New Zealand
 *
 */

package weka.knowledgeflow.steps;

import weka.gui.knowledgeflow.KFGUIConsts;

/**
 * Knowledge Flow step wrapping the ParquetDataSource
 *
 * @author Mark Hall (mhall{[at]}pentaho{[dot]}com)
 * @version $Revision: $
 */
@KFStep(name = "ParquetDataSource", category = "Spark",
  toolTipText = "Loads data from a Parquet file",
  iconPath = KFGUIConsts.BASE_ICON_PATH + "DefaultDataSource.gif")
public class ParquetDataSource extends AbstractDataSource {

  private static final long serialVersionUID = -3575236510978644860L;

  public ParquetDataSource() {
    super();

    m_dataSource = new weka.distributed.spark.ParquetDataSource();
  }
}
