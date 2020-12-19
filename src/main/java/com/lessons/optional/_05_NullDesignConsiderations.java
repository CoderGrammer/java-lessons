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

public class _05_NullDesignConsiderations {

     /*
      - If .getFireHazards() returns null what does that mean?
      - Are there no hazards?
      - Have hazards not been checked yet?
      - Have they been checked but not loaded into the object?
      - Without this context it is dangerous and this design should be avoided
      - We cannot say the building is safe just because hazards is null - we need to first
        be sure what null means in this context
      - This kind of ambiguity is dangerous and needs to be addressed from a design
        perspective
     */
     void missingValue() {
         // getBuilding().getFireHazards() - if null what does it mean??
     }

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

}
