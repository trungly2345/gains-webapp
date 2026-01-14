package com.project.Model;




import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @Column(name = "external_exercise_id", nullable = false, unique = true)
    @JsonProperty("exerciseId")
    private String externalExerciseId;

    @Column(name = "exercise_name", nullable = true)
    @JsonProperty("name")
    private String exerciseName;


    @Column(name = "imageUrl")
    private String imageUrl;

    @ElementCollection
    @CollectionTable (
        name = "excercise_body_parts",
        joinColumns = @JoinColumn(name = "excercise_id")
    )

    @Column(name = "bodypart_name")
    @JsonProperty("bodyParts")
    private List<String> bodyParts = new ArrayList<>();


    @ElementCollection
    @CollectionTable (
        name = "exercise_equpiments",
        joinColumns = @JoinColumn(name = "exercise_id")
    )

    @Column(name = "equipment_name")
    @JsonProperty("equipments")
    private List<String> equipments = new ArrayList<>();

    @Column(name = "exercise_Type")
    @JsonProperty("exerciseType")
    private String exerciseType;


    @ElementCollection
    @CollectionTable (
        name = "excercise_target_muscle",
        joinColumns = @JoinColumn(name = "excercise_id")
    )

    @Column(name = "target_muscle")
    @JsonProperty("targetMuscles")
    private List<String> targetMuscles = new ArrayList<>();


    @ElementCollection
    @CollectionTable (
        name = "excercise_secondary_muscle",
        joinColumns = @JoinColumn(name = "excercise_id")
    )

    @Column(name = "secondary_muscle")
    @JsonProperty("secondaryMuscles")
    private List<String> secondaryMuscles = new ArrayList<>();

    @ElementCollection
    @CollectionTable (
        name = "exercise_keywords",
        joinColumns = @JoinColumn(name = "excercise_id")
    )

    @Column(name = "keywords")
    private List<String> keywords = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalExerciseId() {
        return externalExerciseId;
    }

    public void setExternalExerciseId(String externalExerciseId) {
        this.externalExerciseId = externalExerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(List<String> bodyParts) {
        this.bodyParts = bodyParts;
    }

    public List<String> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<String> equipments) {
        this.equipments = equipments;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public List<String> getTargetMuscles() {
        return targetMuscles;
    }

    public void setTargetMuscles(List<String> targetMuscles) {
        this.targetMuscles = targetMuscles;
    }

    public List<String> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(List<String> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
