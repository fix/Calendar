package calendar

import org.springframework.security.acls.domain.BasePermission
import org.springframework.security.acls.domain.PrincipalSid
import org.springframework.security.acls.model.Permission
import org.springframework.security.acls.model.Sid
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.access.prepost.PostFilter
import org.springframework.security.access.prepost.PreAuthorize

class CalendarFilters {

	def springSecurityService
	def aclUtilService

	def filters = {
		
		save(controller:'calendar', action:'save') {
			after = { model ->
				String username = springSecurityService.authentication.name
				def psid = new PrincipalSid(username)
				def calendar=com.fullcalendar.grails.Calendar.get(flash.calendarid)
				aclUtilService.addPermission calendar, psid, BasePermission.ADMINISTRATION
				return true
			}
		}

		show(controller:'calendar', action:'show'){
			before = {
				return aclUtilService.hasPermission(springSecurityService.authentication, com.fullcalendar.grails.Calendar.get(params.id), BasePermission.ADMINISTRATION)
			}
		}
		
		create(controller:'calendar', action:'create'){
			before = {
				return aclUtilService.hasPermission(springSecurityService.authentication, com.fullcalendar.grails.Calendar.get(params.id), BasePermission.ADMINISTRATION)
			}
		}
		
		update(controller:'calendar', action:'update'){
			before = {
				return aclUtilService.hasPermission(springSecurityService.authentication, com.fullcalendar.grails.Calendar.get(flash.calendarid), BasePermission.ADMINISTRATION)
			}
		}
		
		delete(controller:'calendar', action:'delete'){
			before = {
				return aclUtilService.hasPermission(springSecurityService.authentication, com.fullcalendar.grails.Calendar.get(params.id), BasePermission.ADMINISTRATION)
			}
		}
		
		json(controller:'calendar', action:'json'){
			before = {
				return aclUtilService.hasPermission(springSecurityService.authentication, com.fullcalendar.grails.Calendar.get(params.id), BasePermission.ADMINISTRATION)
			}
		}
		
		ical(controller:'calendar', action:'ical'){
			before = {
				return aclUtilService.hasPermission(springSecurityService.authentication, com.fullcalendar.grails.Calendar.get(params.id), BasePermission.ADMINISTRATION)
			}
		}
		
		edit(controller:'calendar', action:'update'){
			before = {
				return aclUtilService.hasPermission(springSecurityService.authentication, com.fullcalendar.grails.Calendar.get(params.id), BasePermission.ADMINISTRATION)
			}
		}
		
		list(controller:'calendar', action:'list'){
			after = { model->
				//println model
				def output=[]
				model.calendarInstanceList.each { calendar->
					if(aclUtilService.hasPermission(springSecurityService.authentication, calendar, BasePermission.READ, BasePermission.ADMINISTRATION)){
						output.add calendar
					}
				 }
				model.calendarInstanceList=output
			}
		}
	}
}
