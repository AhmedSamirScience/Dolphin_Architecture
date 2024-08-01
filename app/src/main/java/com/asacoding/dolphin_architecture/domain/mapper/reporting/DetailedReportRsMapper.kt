package com.asacoding.dolphin_architecture.domain.mapper.reporting


import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRs
import idhcorp.mokhtabar.chemist.domain.model.remote.reporting.DetailedReport

class DetailedReportRsMapper {
    fun buildFrom(reportDtoRs: ReportDtoRs): DetailedReport {
        return DetailedReport(
            status = DetailedReport.Status(reportDtoRs.status?.code, reportDtoRs.status?.msg),
            numOfTransactions = reportDtoRs.numOfTransactions,
            totalAmount = reportDtoRs.totalAmount,
            paymentList = reportDtoRs.paymentList?.map {
                DetailedReport.Payment(
                    paymentID = it.paymentID,
                    billingAccount = it.billingAccount,
                    clinicName = it.clinicName,
                    amount = it.amount,
                )
            }
        )
    }
}

