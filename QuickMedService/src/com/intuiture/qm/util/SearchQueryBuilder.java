package com.intuiture.qm.util;

import java.util.List;

import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.json.SearchJson;

public class SearchQueryBuilder {
	public static String generateSearchQuery(GridInfoJson gridInfoJson, String query) {
		StringBuilder sb = new StringBuilder();

		if (gridInfoJson.getUserId() != null) {
			if (query.contains("where")) {
				sb.append(" and ");
			} else {
				sb.append(" where ");
			}
			sb.append(" userId = " + gridInfoJson.getUserId());
		}
		if (gridInfoJson.getLocationId() != null) {
			if (query.contains("where")) {
				sb.append(" and ");
			} else {
				sb.append(" where ");
			}
			sb.append(" locationId = " + gridInfoJson.getLocationId());
		}
		if (gridInfoJson.getSearchJsonList() != null && gridInfoJson.getSearchJsonList().size() > 0) {
			for (SearchJson searchJson : gridInfoJson.getSearchJsonList()) {
				if (searchJson.getSelectedOperator() != null && ((searchJson.getSearchValue() != null && searchJson.getSearchValue().trim().length() > 0) || (searchJson.getIds() != null && searchJson.getIds().size() > 0))) {
					if (sb.toString().contains("where")) {
						sb.append(" and ");
					} else {
						sb.append(" where ");
					}
					// "eq", "sw", "ew", "con"
					if (searchJson.getSelectedOperator().equalsIgnoreCase("eq")) {
						sb.append(searchJson.getSelectedSearchFieldName() + "='" + searchJson.getSearchValue() + "'");
					}
					if (searchJson.getSelectedOperator().equalsIgnoreCase("sw")) {
						sb.append(searchJson.getSelectedSearchFieldName() + " like '" + searchJson.getSearchValue() + "%'");
					}
					if (searchJson.getSelectedOperator().equalsIgnoreCase("ew")) {
						sb.append(searchJson.getSelectedSearchFieldName() + " like '%" + searchJson.getSearchValue() + "'");
					}
					if (searchJson.getSelectedOperator().equalsIgnoreCase("con")) {
						sb.append(searchJson.getSelectedSearchFieldName() + " like '%" + searchJson.getSearchValue() + "%'");
					}
					if (searchJson.getSelectedOperator().equalsIgnoreCase("in")) {
						sb.append(searchJson.getSelectedSearchFieldName() + " in (" + removeBrackets(searchJson.getIds()) + ")");
						// sb.append(searchJson.getSelectedSearchFieldName() +
						// " in " + searchJson.getIds() + "");
					}
					// "equal", "gt", "ge", "lt", "le", "ne"
					if (searchJson.getSelectedDataType() != null && searchJson.getSelectedDataType().equalsIgnoreCase("date")) {
						if (searchJson.getSelectedOperator().equalsIgnoreCase("equal")) {

							sb.append(searchJson.getSelectedSearchFieldName() + " = '" + searchJson.getSearchValue() + "'");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("gt")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " > '" + searchJson.getSearchValue() + "'");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("ge")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " >= '" + searchJson.getSearchValue() + "'");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("lt")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " < '" + searchJson.getSearchValue() + "'");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("le")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " <= '" + searchJson.getSearchValue() + "'");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("ne")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " != '" + searchJson.getSearchValue() + "'");
						}
					} else {
						if (searchJson.getSelectedOperator().equalsIgnoreCase("equal")) {

							sb.append(searchJson.getSelectedSearchFieldName() + " = " + searchJson.getSearchValue() + "");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("gt")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " > " + searchJson.getSearchValue() + "");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("ge")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " >= " + searchJson.getSearchValue() + "");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("lt")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " < " + searchJson.getSearchValue() + "");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("le")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " <= " + searchJson.getSearchValue() + "");
						}
						if (searchJson.getSelectedOperator().equalsIgnoreCase("ne")) {
							sb.append(searchJson.getSelectedSearchFieldName() + " != " + searchJson.getSearchValue() + "");
						}
					}
				}
			}
		}
		query += sb.toString();
		return query;
	}

	private static String removeBrackets(List<Integer> ids) {
		String str = null;
		if (ids != null && ids.size() > 0) {
			for (Integer id : ids) {
				if (str == null) {
					str = String.valueOf(id);
				} else {
					str += "," + String.valueOf(id);
				}
			}
		}
		return str;
	}
}
