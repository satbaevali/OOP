package Users;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TechSupportOrder {
    private static final Set<TechSupportOrder> techSupportOrdersRegistry = new HashSet<>();
    private String orderId;
    private String description;
    private boolean isNew;
    private boolean isAccepted;
    private boolean isDone;
    public TechSupportOrder(String orderId, String description, boolean isNew, boolean isAccepted, boolean isDone) {
        this.orderId = orderId;
        this.description = description;
        this.isNew = isNew;
        this.isAccepted = isAccepted;
        this.isDone = isDone;


    }
    public String getOrderId() {
        return orderId;
    }
    public String getDescription() {
        return description;
    }
    public boolean isNew() {
        return isNew;
    }
    public boolean isAccepted() {
        return isAccepted;
    }
    public boolean isDone() {
        return isDone;
    }
    public void  setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public void  setDescription(String description) {
        this.description = description;
    }
    public void  setNew(boolean isNew) {
        this.isNew = isNew;
    }
    public void  setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;

    }
    public void  setDone(boolean isDone) {
        this.isDone = isDone;
    }
    public static void addRegistry(TechSupportOrder techSupportOrder) {
        techSupportOrdersRegistry.add(techSupportOrder);
    }
    public static void removeRegistry(TechSupportOrder techSupportOrder) {
        techSupportOrdersRegistry.remove(techSupportOrder);
    }
    public static TechSupportOrder findRegistry(String orderId) {
        for (TechSupportOrder techSupportOrder : techSupportOrdersRegistry) {
            if (techSupportOrder.getOrderId().equals(orderId)) {
                return techSupportOrder;
            }
        }
        return null;
    }
    public static Set<TechSupportOrder> getNewOrders(){
        Set<TechSupportOrder> newOrders = new HashSet<>();
        for (TechSupportOrder order : techSupportOrdersRegistry) {
            if (order.isNew()) {
                newOrders.add(order);
            }
        }
        return newOrders;
    }
    public static Set<TechSupportOrder> getAcceptedNotDoneOrders(){
        Set<TechSupportOrder> acceptedOrders = new HashSet<>();
        for (TechSupportOrder order : techSupportOrdersRegistry) {
            if (order.isAccepted() && !order.isDone()) {
                acceptedOrders.add(order);
            }
        }
        return acceptedOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechSupportOrder that = (TechSupportOrder) o;
        return isNew == that.isNew && isAccepted == that.isAccepted && isDone == that.isDone && Objects.equals(orderId, that.orderId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, description, isNew, isAccepted, isDone);
    }

    @Override
    public String toString() {
        return "TechSupportOrder{" +
                "orderId='" + orderId + '\'' +
                ", description='" + description + '\'' +
                ", isNew=" + isNew +
                ", isAccepted=" + isAccepted +
                ", isDone=" + isDone +
                '}';
    }

}
