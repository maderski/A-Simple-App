package maderski.asimpleapp.userdirectory.domain.mappers

import maderski.asimpleapp.userdirectory.domain.models.CompanyModel
import maderski.asimpleapp.userdirectory.service.models.Company

class CompanyToCompanyModelMapper {
    operator fun invoke(company: Company?): CompanyModel? =
        company?.let {
            CompanyModel(
                it.name ?: "Unknown",
                it.catchPhase ?: "",
                it.bs ?: ""
            )
        }
}