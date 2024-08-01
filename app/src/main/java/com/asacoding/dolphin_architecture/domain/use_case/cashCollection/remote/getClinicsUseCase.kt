package com.asacoding.dolphin_architecture.domain.use_case.cashCollection.remote


import com.asacoding.dolphin_architecture.common.stateHandling.useCase.RequestResource
import com.asacoding.dolphin_architecture.domain.mapper.cachCollection.clinics.ClinicsRsMapper
import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.Clinics
import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.isDataValid
import com.asacoding.dolphin_architecture.domain.repository.remote.CashCollectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClinicsUseCase @Inject constructor(
    private val repository: CashCollectionRepository
) {
    operator fun invoke(): Flow<RequestResource<Clinics>> = flow {
        try {

            val getClinics = ClinicsRsMapper().buildFrom(clinicsDtoRs = repository.getClinics())
            if (!getClinics.isDataValid()) {
                emit(RequestResource.ErrorResponse(message = "خطأ في البيانات"))
            }

            emit(RequestResource.Success(getClinics))

        } catch (e: HttpException) {
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*e.localizedMessage ?: "An unexpected error occurred"*/))
        } catch (e: IOException) {
            emit(RequestResource.Error(message = "حدث خطأ برجاء المحاولة مرة أخري" /*"تعذر الوصول إلى الخادم. تحقق من اتصالك بالإنترنت."*//*"Couldn't reach server. Check your internet connection."*/))
        }
    }
}