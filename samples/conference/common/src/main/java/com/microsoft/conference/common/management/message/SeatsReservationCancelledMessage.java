package com.microsoft.conference.common.management.message;

import org.enodeframework.infrastructure.ApplicationMessage;

public class SeatsReservationCancelledMessage extends ApplicationMessage {
    public String ConferenceId;
    public String ReservationId;
}
