package com.cqrcb.webapp;

import net.sourceforge.jwebunit.html.Row;
import net.sourceforge.jwebunit.html.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class StaffWebTest {

    private ResourceBundle messages;

    @Before
    public void setUp() {
        setScriptingEnabled(false);
        getTestContext().setBaseUrl("http://" + System.getProperty("cargo.host") + ":" + System.getProperty("cargo.port"));
        getTestContext().setResourceBundleName("messages");
        messages = ResourceBundle.getBundle("messages");
    }

    @Before
    public void addStaff() {
        beginAt("/staffform");
        assertTitleKeyMatches("staffDetail.title");
        setTextField("staffName", "BwEqUnFcNmX");
        setTextField("staffstatus", "4300559664744264704");
        clickButton("save");
        assertTitleKeyMatches("staffList.title");
        assertKeyPresent("staff.added");
    }

    @Test
    public void listStaffs() {
        beginAt("/staffs");
        assertTitleKeyMatches("staffList.title");

        // check that table is present
        assertTablePresent("staffList");
    }

    @Test
    public void editStaff() {
        beginAt("/staffform?id=" + getInsertedId());
        clickButton("save");
        assertTitleKeyMatches("staffDetail.title");
    }

    @Test
    public void saveStaff() {
        beginAt("/staffform?id=" + getInsertedId());
        assertTitleKeyMatches("staffDetail.title");

        // update some of the required fields
        setTextField("staffName", "UqZiAiEyRlF");
        setTextField("staffstatus", "606111008452583424");
        clickButton("save");
        assertTitleKeyMatches("staffDetail.title");
        assertKeyPresent("staff.updated");
    }

    @After
    public void removeStaff() {
        beginAt("/staffform?id=" + getInsertedId());
        clickButton("delete");
        assertTitleKeyMatches("staffList.title");
        assertKeyPresent("staff.deleted");
    }

    /**
     * Convenience method to get the id of the inserted record
     *
     * @return last id in the table
     */
    protected String getInsertedId() {
        beginAt("/staffs");
        assertTablePresent("staffList");
        Table table = getTable("staffList");
        // Find link in last row, skip header row
        for (int i = 1; i < table.getRows().size(); i++) {
            Row row = table.getRows().get(i);
            if (i == table.getRowCount() - 1) {
                return row.getCells().get(0).getValue();
            }
        }
        return "";
    }

    private void assertTitleKeyMatches(String title) {
        assertTitleEquals(messages.getString(title) + " | " + messages.getString("webapp.name"));
    }
}
