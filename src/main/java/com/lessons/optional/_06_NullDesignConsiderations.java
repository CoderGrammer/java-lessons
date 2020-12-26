package com.lessons.optional;


/*
 - Null may be sensible in the given situation from a design perspective
 - We know it signals the absence of a value which makes sense
 - We know that it is lightweight and therefore performant - does not create lots of
   objects
 - So for design purposes consider what does null mean in the context of your application
 - Of course it is not relevant for primitives
 */

import lombok.Getter;

import java.util.List;
import java.util.Objects;

public class _06_NullDesignConsiderations {

     /*
      - If building.getFireHazards() returns null what does that mean?
      - Are there no hazards?
      - Have hazards not been checked yet?
      - Have they been checked but not loaded into the object?
      - Without this context it is dangerous and this design should be avoided
      - We cannot say the building is safe just because hazards is null - we need to first
        be sure what null means in this context
      - This kind of ambiguity is dangerous and needs to be addressed from a design
        perspective
      - In the real world null tends to be used to represent:
         - The absence of a value: e.g. e.getMiddleName()
         - A value which is not known: e.g. b.getFireHazards() - you don't know the
           value yet and may never know
         - Something not yet initialized: e.g. g.getCount() - you intend to init
           later
         - The end of a pipeline of data (a termination condition) - x.getNextItem()
         - A specific value in your context e.g. if an employee.getStatus() is null
           then they are to be fired - constitutes a DSL and usually a bad idea
     */
     void missingValue() {
         // getBuilding().getFireHazards() - if null what does it mean??
     }

     /*
      - In this example we try to close off all the possible scenarios
      - Such that there is no ambiguity
      - Either hazards are:
         - Not loaded
         - Loaded but there are no hazards
         - Loaded and there are hazards
     */
     @Getter
     static class Building {

         static class Hazards {

             List<String> hazards;
             HazardsCheckStatus hazardsCheckStatus = HazardsCheckStatus.NOT_LOADED;

             enum HazardsCheckStatus {
                 NOT_LOADED, LOADED
             }

             boolean isHazardsLoaded() {
                 return hazardsCheckStatus == HazardsCheckStatus.LOADED;
             }

             List<String> getHazards() {
                 if (hazardsCheckStatus == HazardsCheckStatus.NOT_LOADED) {
                     throw new IllegalStateException("Hazards have not yet been loaded." +
                                                             " Call isHazardsLoaded() " +
                                                             "before calling this " +
                                                             "method");
                 }
                 return hazards;
             }

             void setHazards(List<String> hazards) {
                 Objects.requireNonNull(hazards,
                                        "hazards cannot be null. They can be empty list" +
                                                " if there are no hazards. Do not call " +
                                                "this method with a default value.");
                 this.hazards = hazards;
                 this.hazardsCheckStatus = HazardsCheckStatus.LOADED;
             }
         }

         Hazards hazards;

     }

     /*
      - Recap:
         - Think before returning null
         - If you do return null it should have a clear and simple meaning
         - E.g. a value which does not exist for the given entity e.g. employee
           .getMiddleName()
         - Try to avoid null having a special meaning such as a null status which means
           an employee should be fired. It would be better to return a status of
           FIRE_EMPLOYEE
     */

}
