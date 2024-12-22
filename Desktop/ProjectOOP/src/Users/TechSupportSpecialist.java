package Users;

import java.util.Set;

public class TechSupportSpecialist {
    public Set<TechSupportOrder> viewNewOrders() {
        return TechSupportOrder.getNewOrders();
    }


    public void acceptOrder(TechSupportOrder order) {
        if (order.isNew()) {
            order.setAccepted(true);
            order.setNew(false);
            System.out.println("Order " + order.getOrderId() + " has been accepted.");
        } else {
            System.out.println("Order " + order.getOrderId() + " cannot be accepted as it's not new.");
        }
    }


    public void rejectOrder(TechSupportOrder order) {
        if (order.isNew()) {
            order.setAccepted(false);
            System.out.println("Order " + order.getOrderId() + " has been rejected.");
        } else {
            System.out.println("Order " + order.getOrderId() + " cannot be rejected as it's already processed.");
        }
    }


    public Set<TechSupportOrder> viewAcceptedNotDoneOrders() {
        return TechSupportOrder.getAcceptedNotDoneOrders();
    }
}
