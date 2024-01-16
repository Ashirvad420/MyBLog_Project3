package com.SpringApi.SpringApi11.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ErrorDeteils {

   private String message;
   private Date date;
   private String uri;

}
