package datamanagement;
public class ListUnitsCTL {
    private UnitManager um;
public ListUnitsCTL() {
        um = UnitManager.UM();
}
            public void listUnits( UnitLister lister ) {
lister.clearUnits();
UnitMap units = um.getUnits();
        for (String s : units.keySet() )
            lister.addUnit(units.get(s));}}
