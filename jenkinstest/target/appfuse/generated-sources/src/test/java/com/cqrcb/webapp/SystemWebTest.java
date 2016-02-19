package com.cqrcb.webapp;

import net.sourceforge.jwebunit.html.Row;
import net.sourceforge.jwebunit.html.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class SystemWebTest {

    private ResourceBundle messages;

    @Before
    public void setUp() {
        setScriptingEnabled(false);
        getTestContext().setBaseUrl("http://" + System.getProperty("cargo.host") + ":" + System.getProperty("cargo.port"));
        getTestContext().setResourceBundleName("messages");
        messages = ResourceBundle.getBundle("messages");
    }

    @Before
    public void addSystem() {
        beginAt("/systemform");
        assertTitleKeyMatches("systemDetail.title");
        setTextField("systemAbbreviation", "RwUkNhFmQiKaBuKi");
        setTextField("systemName", "TxDxXfCrVuAgNaKoCmElSaWcNtPfIcNeKvArNdXsEgHwRyXwHcLoOzJkJmIpTuEz");
        clickButton("save");
        assertTitleKeyMatches("systemList.title");
        assertKeyPresent("system.added");
    }

    @Test
    public void listSystems() {
        beginAt("/systems");
        assertTitleKeyMatches("systemList.title");

        // check that table is present
        assertTablePresent("systemList");
    }

    @Test
    public void editSystem() {
        beginAt("/systemform?id=" + getInsertedId());
        clickButton("save");
        assertTitleKeyMatches("systemDetail.title");
    }

    @Test
    public void saveSystem() {
        beginAt("/systemform?id=" + getInsertedId());
        assertTitleKeyMatches("systemDetail.title");

        // update some of the required fields
        setTextField("systemAbbreviation", "OgUgToBfWsVyVjIe");
        setTextField("systemName", "FwQkYmAkXoXqRrAmGwClWnWaGvWtTsPtZdAoVqFyLfHeDtSiKxBsIrBnUlDcTqQz");
        clickButton("save");
        assertTitleKeyMatches("systemDetail.title");
        assertKeyPresent("system.updated");
    }

    @After
    public void removeSystem() {
        beginAt("/systemform?id=" + getInsertedId());
        clickButton("delete");
        assertTitleKeyMatches("systemList.title");
        assertKeyPresent("system.deleted");
    }

    /**
     * Convenience method to get the id of the inserted record
     *
     * @return last id in the table
     */
    protected String getInsertedId() {
        beginAt("/systems");
        assertTablePresent("systemList");
        Table table = getTable("systemList");
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
