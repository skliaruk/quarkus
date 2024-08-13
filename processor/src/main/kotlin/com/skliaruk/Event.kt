package com.skliaruk


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "event")
class Event : PanacheEntity() {
    companion object : PanacheCompanion<Event>

    lateinit var name: String
    lateinit var type: String
    lateinit var value: String
}