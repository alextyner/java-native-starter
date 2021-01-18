#pragma once

#ifndef EXPORT_H
#define EXPORT_H

#if defined(_WIN32)
#define DLL_EXPORT __declspec(dllexport)
#else
#define DLL_EXPORT
#endif
#if defined(__cplusplus)
#define EXTERN extern "C"
#else
#define EXTERN
#endif
#define EXPORTED EXTERN DLL_EXPORT

#endif