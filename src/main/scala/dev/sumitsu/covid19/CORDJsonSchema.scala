package dev.sumitsu.covid19

import io.circe.generic.extras._

object CORDJsonSchema {
  final case class CORDJsonAuthorAffiliation(
    laboratory: Option[String],
    institution: Option[String],
    location: Option[Map[String, String]]
  )
  final case class CORDJsonAuthor(
    first: Option[String],
    middle: Option[Seq[String]],
    last: Option[String],
    suffix: Option[String],
    affiliation: Option[CORDJsonAuthorAffiliation],
    email: Option[String]
  )
  final case class CORDJsonMetadata(
    title: Option[String],
    authors: Option[Seq[CORDJsonAuthor]]
  )
  final case class CORDJsonRefSpan(
    start: Option[Int],
    end: Option[Int],
    text: Option[String],
    ref_id: Option[String]
  )
  final case class CORDJsonExcerpt(
    text: Option[String],
    cite_spans: Option[Seq[CORDJsonRefSpan]],
    ref_spans: Option[Seq[CORDJsonRefSpan]],
    eq_spans: Option[Seq[CORDJsonRefSpan]],
    section: Option[String]
  )
  final case class CORDBiblioEntry(
    ref_id: Option[String],
    title: Option[String],
    authors: Option[Seq[CORDJsonAuthor]],
    year: Option[Int],
    venue: Option[String],
    volume: Option[String],
    issn: Option[String],
    pages: Option[String],
    other_ids: Option[Map[String, Seq[String]]]
  )
  final case class CORDRefEntry(
    text: Option[String],
    @JsonKey("type")
    refType: Option[String]
  )
  final case class CORDJsonDocument(
    paper_id: Option[String],
    metadata: Option[CORDJsonMetadata],
    @JsonKey("abstract")
    paperAbstract: Option[Option[Seq[CORDJsonExcerpt]]],
    body_text: Option[Seq[CORDJsonExcerpt]],
    bib_entries: Option[Map[String, CORDBiblioEntry]],
    ref_entries: Option[Map[String, CORDRefEntry]],
    back_matter: Option[Seq[CORDJsonExcerpt]]
  )
}
