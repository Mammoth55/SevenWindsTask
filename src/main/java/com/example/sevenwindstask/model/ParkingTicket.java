package com.example.sevenwindstask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity(name = "parking_tickets")
public class ParkingTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "place_id", columnDefinition = "bigint not null")
    private ParkingPlace parkingPlace;

    @OneToOne
    @JoinColumn(name = "user_id", columnDefinition = "bigint not null")
    private User user;

    @Column(name = "start_time", columnDefinition = "timestamp not null default now()")
    private Instant startTime;

    @Column(name = "duration_minutes", columnDefinition = "int not null default 30")
    private int durationInMinutes;

    @Column(name = "prepaid", columnDefinition = "boolean not null default 'FALSE'")
    private boolean prepaid;
}

//    select u.car_number,
//        pp.number,
//        pt.start_time::timestamp(0),
//        (pp.price * EXTRACT(epoch FROM date_trunc('minute', age(current_timestamp, pt.start_time)) / 60)) as total
//        from parking_tickets pt
//        join parking_places pp on pp.id = pt.place_id
//        join users u on u.id = pt.user_id