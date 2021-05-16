package org.demo.timetabling.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.demo.timetabling.domain.Room;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class RoomResource {

	@POST
	public Response add(Room room) {
		Room.persist(room);
		return Response.accepted(room).build();
	}
	
	@DELETE
	@Path("{roomId}")
	public Response delete(@PathParam("roomId") Long roomId) {
		Room room = Room.findById(roomId);
		if(room == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		room.delete();
		return Response.status(Response.Status.OK).build();
	}
}
