package eu.senla.data;

public record LeaveEntitlement(
    Integer empNumber,
    Integer leaveTypeId,
    String fromDate,
    String toDate,
    String entitlement) {
}
