package eu.senla.dataApi;

public record LeaveEntitlementRequest(
    Integer empNumber,
    Integer leaveTypeId,
    String fromDate,
    String toDate,
    String entitlement) {
}
