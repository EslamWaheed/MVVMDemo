package com.eslamwaheed.mvvmdemo.data

import com.google.gson.annotations.SerializedName

data class UnsplashSearchResponse(
    @SerializedName("total")
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("results")
    val results: ArrayList<Result?>?
) {
    data class Result(
        @SerializedName("id")
        val id: String?,
        @SerializedName("created_at")
        val createdAt: String?,
        @SerializedName("updated_at")
        val updatedAt: String?,
        @SerializedName("promoted_at")
        val promotedAt: String?,
        @SerializedName("width")
        val width: Int?,
        @SerializedName("height")
        val height: Int?,
        @SerializedName("color")
        val color: String?,
        @SerializedName("blur_hash")
        val blurHash: String?,
        @SerializedName("description")
        val description: Any?,
        @SerializedName("alt_description")
        val altDescription: String?,
        @SerializedName("urls")
        val urls: Urls?,
        @SerializedName("links")
        val links: Links?,
        @SerializedName("categories")
        val categories: List<Any?>?,
        @SerializedName("likes")
        val likes: Int?,
        @SerializedName("liked_by_user")
        val likedByUser: Boolean?,
        @SerializedName("current_user_collections")
        val currentUserCollections: List<Any?>?,
        @SerializedName("sponsorship")
        val sponsorship: Any?,
        @SerializedName("topic_submissions")
        val topicSubmissions: TopicSubmissions?,
        @SerializedName("user")
        val user: User?,
        @SerializedName("tags")
        val tags: List<Tag?>?
    ) {
        data class Urls(
            @SerializedName("raw")
            val raw: String?,
            @SerializedName("full")
            val full: String?,
            @SerializedName("regular")
            val regular: String?,
            @SerializedName("small")
            val small: String?,
            @SerializedName("thumb")
            val thumb: String?,
            @SerializedName("small_s3")
            val smallS3: String?
        )

        data class Links(
            @SerializedName("self")
            val self: String?,
            @SerializedName("html")
            val html: String?,
            @SerializedName("download")
            val download: String?,
            @SerializedName("download_location")
            val downloadLocation: String?
        )

        class TopicSubmissions

        data class User(
            @SerializedName("id")
            val id: String?,
            @SerializedName("updated_at")
            val updatedAt: String?,
            @SerializedName("username")
            val username: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("first_name")
            val firstName: String?,
            @SerializedName("last_name")
            val lastName: String?,
            @SerializedName("twitter_username")
            val twitterUsername: String?,
            @SerializedName("portfolio_url")
            val portfolioUrl: String?,
            @SerializedName("bio")
            val bio: String?,
            @SerializedName("location")
            val location: String?,
            @SerializedName("links")
            val links: Links?,
            @SerializedName("profile_image")
            val profileImage: ProfileImage?,
            @SerializedName("instagram_username")
            val instagramUsername: String?,
            @SerializedName("total_collections")
            val totalCollections: Int?,
            @SerializedName("total_likes")
            val totalLikes: Int?,
            @SerializedName("total_photos")
            val totalPhotos: Int?,
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean?,
            @SerializedName("for_hire")
            val forHire: Boolean?,
            @SerializedName("social")
            val social: Social?
        ) {
            data class Links(
                @SerializedName("self")
                val self: String?,
                @SerializedName("html")
                val html: String?,
                @SerializedName("photos")
                val photos: String?,
                @SerializedName("likes")
                val likes: String?,
                @SerializedName("portfolio")
                val portfolio: String?,
                @SerializedName("following")
                val following: String?,
                @SerializedName("followers")
                val followers: String?
            )

            data class ProfileImage(
                @SerializedName("small")
                val small: String?,
                @SerializedName("medium")
                val medium: String?,
                @SerializedName("large")
                val large: String?
            )

            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String?,
                @SerializedName("portfolio_url")
                val portfolioUrl: String?,
                @SerializedName("twitter_username")
                val twitterUsername: String?,
                @SerializedName("paypal_email")
                val paypalEmail: Any?
            )
        }

        data class Tag(
            @SerializedName("type")
            val type: String?,
            @SerializedName("title")
            val title: String?,
            @SerializedName("source")
            val source: Source?
        ) {
            data class Source(
                @SerializedName("ancestry")
                val ancestry: Ancestry?,
                @SerializedName("title")
                val title: String?,
                @SerializedName("subtitle")
                val subtitle: String?,
                @SerializedName("description")
                val description: String?,
                @SerializedName("meta_title")
                val metaTitle: String?,
                @SerializedName("meta_description")
                val metaDescription: String?,
                @SerializedName("cover_photo")
                val coverPhoto: CoverPhoto?
            ) {
                data class Ancestry(
                    @SerializedName("type")
                    val type: Type?,
                    @SerializedName("category")
                    val category: Category?,
                    @SerializedName("subcategory")
                    val subcategory: Subcategory?
                ) {
                    data class Type(
                        @SerializedName("slug")
                        val slug: String?,
                        @SerializedName("pretty_slug")
                        val prettySlug: String?
                    )

                    data class Category(
                        @SerializedName("slug")
                        val slug: String?,
                        @SerializedName("pretty_slug")
                        val prettySlug: String?
                    )

                    data class Subcategory(
                        @SerializedName("slug")
                        val slug: String?,
                        @SerializedName("pretty_slug")
                        val prettySlug: String?
                    )
                }

                data class CoverPhoto(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("created_at")
                    val createdAt: String?,
                    @SerializedName("updated_at")
                    val updatedAt: String?,
                    @SerializedName("promoted_at")
                    val promotedAt: String?,
                    @SerializedName("width")
                    val width: Int?,
                    @SerializedName("height")
                    val height: Int?,
                    @SerializedName("color")
                    val color: String?,
                    @SerializedName("blur_hash")
                    val blurHash: String?,
                    @SerializedName("description")
                    val description: String?,
                    @SerializedName("alt_description")
                    val altDescription: String?,
                    @SerializedName("urls")
                    val urls: Urls?,
                    @SerializedName("links")
                    val links: Links?,
                    @SerializedName("categories")
                    val categories: List<Any?>?,
                    @SerializedName("likes")
                    val likes: Int?,
                    @SerializedName("liked_by_user")
                    val likedByUser: Boolean?,
                    @SerializedName("current_user_collections")
                    val currentUserCollections: List<Any?>?,
                    @SerializedName("sponsorship")
                    val sponsorship: Any?,
                    @SerializedName("topic_submissions")
                    val topicSubmissions: TopicSubmissions?,
                    @SerializedName("user")
                    val user: User?
                ) {
                    data class Urls(
                        @SerializedName("raw")
                        val raw: String?,
                        @SerializedName("full")
                        val full: String?,
                        @SerializedName("regular")
                        val regular: String?,
                        @SerializedName("small")
                        val small: String?,
                        @SerializedName("thumb")
                        val thumb: String?,
                        @SerializedName("small_s3")
                        val smallS3: String?
                    )

                    data class Links(
                        @SerializedName("self")
                        val self: String?,
                        @SerializedName("html")
                        val html: String?,
                        @SerializedName("download")
                        val download: String?,
                        @SerializedName("download_location")
                        val downloadLocation: String?
                    )

                    data class TopicSubmissions(
                        @SerializedName("business-work")
                        val businessWork: BusinessWork?
                    ) {
                        data class BusinessWork(
                            @SerializedName("status")
                            val status: String?,
                            @SerializedName("approved_on")
                            val approvedOn: String?
                        )
                    }

                    data class User(
                        @SerializedName("id")
                        val id: String?,
                        @SerializedName("updated_at")
                        val updatedAt: String?,
                        @SerializedName("username")
                        val username: String?,
                        @SerializedName("name")
                        val name: String?,
                        @SerializedName("first_name")
                        val firstName: String?,
                        @SerializedName("last_name")
                        val lastName: String?,
                        @SerializedName("twitter_username")
                        val twitterUsername: Any?,
                        @SerializedName("portfolio_url")
                        val portfolioUrl: Any?,
                        @SerializedName("bio")
                        val bio: String?,
                        @SerializedName("location")
                        val location: String?,
                        @SerializedName("links")
                        val links: Links?,
                        @SerializedName("profile_image")
                        val profileImage: ProfileImage?,
                        @SerializedName("instagram_username")
                        val instagramUsername: String?,
                        @SerializedName("total_collections")
                        val totalCollections: Int?,
                        @SerializedName("total_likes")
                        val totalLikes: Int?,
                        @SerializedName("total_photos")
                        val totalPhotos: Int?,
                        @SerializedName("accepted_tos")
                        val acceptedTos: Boolean?,
                        @SerializedName("for_hire")
                        val forHire: Boolean?,
                        @SerializedName("social")
                        val social: Social?
                    ) {
                        data class Links(
                            @SerializedName("self")
                            val self: String?,
                            @SerializedName("html")
                            val html: String?,
                            @SerializedName("photos")
                            val photos: String?,
                            @SerializedName("likes")
                            val likes: String?,
                            @SerializedName("portfolio")
                            val portfolio: String?,
                            @SerializedName("following")
                            val following: String?,
                            @SerializedName("followers")
                            val followers: String?
                        )

                        data class ProfileImage(
                            @SerializedName("small")
                            val small: String?,
                            @SerializedName("medium")
                            val medium: String?,
                            @SerializedName("large")
                            val large: String?
                        )

                        data class Social(
                            @SerializedName("instagram_username")
                            val instagramUsername: String?,
                            @SerializedName("portfolio_url")
                            val portfolioUrl: Any?,
                            @SerializedName("twitter_username")
                            val twitterUsername: Any?,
                            @SerializedName("paypal_email")
                            val paypalEmail: Any?
                        )
                    }
                }
            }
        }
    }
}