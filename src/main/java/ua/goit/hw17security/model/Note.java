package ua.goit.hw17security.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    @SequenceGenerator(name = "note_seq", sequenceName = "seq_note_id", allocationSize = 1)
    private Long id;
    private String title;
    private String content;
}
